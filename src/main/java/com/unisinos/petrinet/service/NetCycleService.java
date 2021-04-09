package com.unisinos.petrinet.service;

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
        transitions.stream().forEach(transition -> new TransitionCycleService(transition).runCycle());
    }
}
