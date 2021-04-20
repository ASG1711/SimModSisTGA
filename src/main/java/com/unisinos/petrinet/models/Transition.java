package com.unisinos.petrinet.models;

import com.unisinos.petrinet.models.orderedArcs.AbstractOrderedArc;
import com.unisinos.petrinet.models.orderedArcs.PlaceToTransitionArc;
import com.unisinos.petrinet.models.orderedArcs.TransitionToPlaceArc;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "transition")
public class Transition extends Element {
    @Setter
    @Getter
    private List<AbstractOrderedArc> arcs = new ArrayList<>();

    private boolean enabled;

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabledVerifyingArcs() {
        enabled = getSourceArcs().stream().allMatch(PlaceToTransitionArc::isEnabled);
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

    public void moveMarks() {
        while (isEnabled()) {
            movePlaceToTransition();
            moveTransitionToPlace();
            setEnabledVerifyingArcs();
            if(hasOnlyNonMoveTypeArcs()){
                disable();
            }
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

    @Override
    public String toString() {
        return String.format("ID: %s LABEL: %s HABILITADA: %s \n", getId(), getLabel(), isEnabled().toString());
    }
}
