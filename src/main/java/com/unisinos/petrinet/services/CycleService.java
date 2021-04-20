package com.unisinos.petrinet.services;

import com.unisinos.petrinet.models.ArcType;
import com.unisinos.petrinet.models.Document;
import com.unisinos.petrinet.models.Net;
import com.unisinos.petrinet.models.Transition;
import com.unisinos.petrinet.models.orderedArcs.PlaceToTransitionArc;
import com.unisinos.petrinet.models.orderedArcs.TransitionToPlaceArc;

import java.util.List;
import java.util.logging.Logger;

public class CycleService {
    Logger logger = Logger.getLogger("com.unisinos.petrinet.services.CycleService");

    public Integer getCyclesQuantityToFinish(Document document) {
        Integer totalCycles = 0;
        while (!allTransitionsDisabled(document)){
            totalCycles++;
            logger.info(String.format("CYCLE: %s",totalCycles));
            runCycle(document);
        }
        return totalCycles;
    }

    public void runCycles(Document document, Integer cycles) {
        for (int i = 0; i < cycles; i++) {
            logger.info(String.format("CYCLE: %s",i));
            runCycle(document);
        }
    }

    public void runCycle(Document document){
        List<Net> nets = document.getNets();
        for (Net net : nets) {
            for (Transition transition : net.getTransitions()) {
                moveMarks(transition);
            }
            for (Transition transition : net.getTransitions()){
                transition.setEnabledVerifyingArcs();
            }
        }
        logger.info(document.toString());
    }

    private void moveMarks(Transition transition) {
        while (transition.isEnabled()) {
            movePlaceToTransition(transition);
            moveTransitionToPlace(transition);
            transition.setEnabledVerifyingArcs();
            if(hasOnlyNonMoveTypeArcs(transition)){
                transition.disable();
            }
        }
    }

    private void movePlaceToTransition(Transition transition) {
        for (PlaceToTransitionArc arc : transition.getSourceArcs()) {
            arc.move();
        }
    }

    private void moveTransitionToPlace(Transition transition) {
        for (TransitionToPlaceArc arc : transition.getDestinationArcs()) {
            arc.move();
        }
    }

    private boolean hasOnlyNonMoveTypeArcs(Transition transition) {
        return transition.getSourceArcs().stream().allMatch(arc -> isReset(arc) || isInhibitor(arc));
    }

    private boolean isInhibitor(PlaceToTransitionArc arc) {
        return arc.getType().equals(ArcType.INHIBITOR);
    }

    private boolean isReset(PlaceToTransitionArc arc) {
        return arc.getType().equals(ArcType.RESET);
    }

    private boolean allTransitionsDisabled(Document document) {
        return document.getNets().stream().allMatch(net -> net.getTransitions().stream().noneMatch(Transition::isEnabled));
    }
}
