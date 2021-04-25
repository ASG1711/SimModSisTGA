package com.unisinos.petrinet.services;

import com.unisinos.petrinet.models.Document;
import com.unisinos.petrinet.models.Net;
import com.unisinos.petrinet.models.Transition;

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

    private void runCycle(Document document){
        List<Net> nets = document.getNets();
        for (Net net : nets) {
            for (Transition transition : net.getTransitions()) {
               transition.move();
            }
            for (Transition transition : net.getTransitions()){
                transition.setEnabledVerifyingArcs();
            }
        }
        logger.info(document.toString());
    }
    private boolean allTransitionsDisabled(Document document) {
        return document.getNets().stream().allMatch(net -> net.getTransitions().stream().noneMatch(Transition::isEnabled));
    }
}
