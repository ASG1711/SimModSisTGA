package com.unisinos.petrinet.pflowimport;

import com.unisinos.petrinet.models.Document;
import com.unisinos.petrinet.models.Net;
import com.unisinos.petrinet.models.Transition;
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

    // TODO: TA COMPARANDO OS ARCOS E TEM QUE COMPARAR OS PLACES
    private void populateConflictingTransitions(List<Transition> transitionList, Transition currentTransition) {
        transitionList.forEach(transition -> {
            if(hasCommonSources(currentTransition, transition)){
                currentTransition.getConflictingTransitions().add(transition);
            }
        });
    }

    private boolean hasCommonSources(Transition currentTransition, Transition transition) {
        return Collections.disjoint(currentTransition.getSourceArcs(), transition.getSourceArcs());
    }

    private void addArcToTransition(com.unisinos.petrinet.models.Arc arc) {
        if (arc.getDestination() instanceof Transition) ((Transition) arc.getDestination()).getArcs().add(new PlaceToTransitionArc(arc));
        if (arc.getSource() instanceof Transition) ((Transition) arc.getSource()).getArcs().add(new TransitionToPlaceArc(arc));
    }
}
