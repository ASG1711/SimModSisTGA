package com.unisinos.petrinet.services;

import com.unisinos.petrinet.models.Document;
import com.unisinos.petrinet.models.Net;
import com.unisinos.petrinet.models.Transition;
import com.unisinos.petrinet.models.orderedArcs.PlaceToTransitionArc;
import com.unisinos.petrinet.models.orderedArcs.TransitionToPlaceArc;

import java.util.List;

public class CycleService {

    public void runCycle(Document document){

        List<Net> nets = document.getNets();
        for (Net net : nets) {
            for (Transition transition : net.getTransitions()) {
                if(transition.isEnabled()) {
                    for (PlaceToTransitionArc arc : transition.getSourceArcs()) {
                        arc.move();
                    }
                    for (TransitionToPlaceArc arc : transition.getDestinationArcs()) {
                        arc.move();
                    }
                    transition.disable();
                }
            }
            for (Transition transition : net.getTransitions()){
                transition.setEnabled();
            }
        }
    }
}
