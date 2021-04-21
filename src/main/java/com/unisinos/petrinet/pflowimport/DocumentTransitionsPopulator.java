package com.unisinos.petrinet.pflowimport;

import com.unisinos.petrinet.models.*;
import com.unisinos.petrinet.models.orderedArcs.PlaceToTransitionArc;
import com.unisinos.petrinet.models.orderedArcs.TransitionToPlaceArc;

import java.util.Collections;
import java.util.List;

public class DocumentTransitionsPopulator {
    public void populate(Document document) {
        document.getNets().forEach(this::populateNet);
    }

    private void populateNet(Net net) {
        net.getArcs().forEach(this::addArcToTransition);
        net.getTransitions().forEach(currentTransition -> {
            currentTransition.setEnabledVerifyingArcs();
            populateConflictingTransitions(net.getTransitions(), currentTransition);
        });
    }

    private void populateConflictingTransitions(List<Transition> transitionList, Transition currentTransition) {
        List<Place> currentPlaces = currentTransition.getSourcePlaces();
        transitionList.forEach(transition -> {
            if(!transition.equals(currentTransition) && hasCommonSources(currentPlaces, transition)){
                currentTransition.getConflictingTransitions().add(transition);
            }
        });
        if(!currentTransition.getConflictingTransitions().isEmpty()) addSelfAsConflict(currentTransition);
    }

    private boolean addSelfAsConflict(Transition currentTransition) {
        return currentTransition.getConflictingTransitions().add(currentTransition);
    }

    private boolean hasCommonSources(List<Place> currentPlaces, Transition transition) {
        List<Place> comparingPlaces = transition.getSourcePlaces();
        return !Collections.disjoint(currentPlaces, comparingPlaces);
    }

    private void addArcToTransition(com.unisinos.petrinet.models.Arc arc) {
        if (arc.getDestination() instanceof Transition) ((Transition) arc.getDestination()).getArcs().add(new PlaceToTransitionArc(arc));
        if (arc.getSource() instanceof Transition) ((Transition) arc.getSource()).getArcs().add(new TransitionToPlaceArc(arc));
    }
}
