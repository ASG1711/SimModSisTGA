package com.unisinos.petrinet.cycleservice;

import com.unisinos.petrinet.models.Transition;

public class TransitionCycleService extends AbstractCycleService <Transition> {

    public TransitionCycleService(Transition element) {
        super(element);
    }

    @Override
    void runCycle() {
        Transition transition = getElement();
        transition.getSourceArcs().forEach(arc -> {
            arc.getPlace().setToken(arc.getPlace().getToken() - arc.getMultiplicity());
        });
        transition.getDestinationArcs().forEach(arc -> {
            arc.getPlace().setToken(arc.getPlace().getToken() + arc.getMultiplicity());
        });
    }




}
