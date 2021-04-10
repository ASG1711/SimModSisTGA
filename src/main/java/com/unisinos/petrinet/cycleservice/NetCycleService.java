package com.unisinos.petrinet.cycleservice;

import com.unisinos.petrinet.models.Net;
import com.unisinos.petrinet.models.Transition;

import java.util.List;

public class NetCycleService extends AbstractCycleService <Net>{

    public NetCycleService(Net element) {
        super(element);
    }

    @Override
    void runCycle() {
        List<Transition> transitions = getElement().getTransitions();
        transitions.stream()
                .filter(Transition::isEnabled)
                .forEach(this::runTransitionCycle);
    }

    private void runTransitionCycle(Transition transition) {
        new TransitionCycleService(transition).runCycle();
    }
}
