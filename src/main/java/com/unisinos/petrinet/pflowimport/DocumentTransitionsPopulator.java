package com.unisinos.petrinet.pflowimport;

import com.unisinos.petrinet.models.Document;
import com.unisinos.petrinet.models.Net;
import com.unisinos.petrinet.models.Transition;
import com.unisinos.petrinet.models.orderedArcs.PlaceToTransitionArc;
import com.unisinos.petrinet.models.orderedArcs.TransitionToPlaceArc;

public class DocumentTransitionsPopulator {
    public void populate(Document document) {
        document.getNets().forEach(this::populateNet);
    }

    private void populateNet(Net net) {
        net.getArcs().forEach(this::addArcToTransition);
        net.getTransitions().forEach(Transition::setEnabledVerifyingArcs);
    }

    private void addArcToTransition(com.unisinos.petrinet.models.Arc arc) {
        if (arc.getDestination() instanceof Transition) ((Transition) arc.getDestination()).getArcs().add(new PlaceToTransitionArc(arc));
        if (arc.getSource() instanceof Transition) ((Transition) arc.getSource()).getArcs().add(new TransitionToPlaceArc(arc));
    }
}
