package com.unisinos.petrinet.models;

import com.unisinos.petrinet.models.orderedArcs.AbstractOrderedArc;
import com.unisinos.petrinet.models.orderedArcs.PlaceToTransitionArc;
import com.unisinos.petrinet.models.orderedArcs.TransitionToPlaceArc;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@XmlRootElement(name = "transition")
public class Transition extends Element {

    private List<AbstractOrderedArc> arcs = new ArrayList<>();

    private List<Transition> conflictingTransitions = new ArrayList<>();

    private boolean enabled;

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabledVerifyingArcs() {
        enabled = getSourceArcs().stream().allMatch(PlaceToTransitionArc::isEnabled);
    }

    public List<Place> getSourcePlaces() {
        return getSourceArcs().stream().map(placeToTransitionArc -> (Place) placeToTransitionArc.getSource()).collect(Collectors.toList());
    }

    public void disable(){
        enabled = false;
    }

    public List<PlaceToTransitionArc> getSourceArcs() {
        return arcs.stream()
                .filter(arc -> arc instanceof PlaceToTransitionArc)
                .map(arc -> (PlaceToTransitionArc)arc)
                .collect(Collectors.toList());
    }

    public List<TransitionToPlaceArc> getDestinationArcs() {
        return arcs.stream()
                .filter(arc -> arc instanceof TransitionToPlaceArc)
                .map(arc -> (TransitionToPlaceArc)arc)
                .collect(Collectors.toList());
    }

    public void move() {
        if(getConflictingTransitions().isEmpty()){
            moveWhileEnabled();
        } else {
            moveConflicts();
        }
    }

    private void moveConflicts(){
        while(getConflictingTransitions().stream().anyMatch(Transition::isEnabled)){
            List<Transition> enabledTransitions = getConflictingTransitions()
                    .stream()
                    .filter(Transition::isEnabled)
                    .collect(Collectors.toList());
            Random random = new Random();
            int randomIndex = random.nextInt(enabledTransitions.size());
            enabledTransitions.get(randomIndex).doMove();
            enabledTransitions.forEach(Transition::resetEnabledForLoop);
        }
    }

    private void moveWhileEnabled() {
        while (isEnabled()) {
            doMove();
        }
    }

    private void doMove() {
        movePlaceToTransition();
        moveTransitionToPlace();
        resetEnabledForLoop();
    }

    private void resetEnabledForLoop() {
        if(hasOnlyNonMoveTypeArcs()){
            disable();
        } else {
            setEnabledVerifyingArcs();
        }
    }

    private void movePlaceToTransition() {
        for (PlaceToTransitionArc arc : getSourceArcs()) {
            arc.move();
        }
    }

    private void moveTransitionToPlace() {
        for (TransitionToPlaceArc arc : getDestinationArcs()) {
            arc.move();
        }
    }

    private boolean hasOnlyNonMoveTypeArcs() {
        return getSourceArcs().stream().allMatch(arc -> isReset(arc) || isInhibitor(arc));
    }

    private boolean isInhibitor(PlaceToTransitionArc arc) {
        return arc.getType().equals(ArcType.INHIBITOR);
    }

    private boolean isReset(PlaceToTransitionArc arc) {
        return arc.getType().equals(ArcType.RESET);
    }

    public List<AbstractOrderedArc> getArcs() {
        return arcs;
    }

    public void setArcs(List<AbstractOrderedArc> arcs) {
        this.arcs = arcs;
    }

    public List<Transition> getConflictingTransitions() {
        return conflictingTransitions;
    }

    public void setConflictingTransitions(List<Transition> conflictingTransitions) {
        this.conflictingTransitions = conflictingTransitions;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return String.format("ID: %s LABEL: %s HABILITADA: %s \n", getId(), getLabel(), isEnabled().toString());
    }
}
