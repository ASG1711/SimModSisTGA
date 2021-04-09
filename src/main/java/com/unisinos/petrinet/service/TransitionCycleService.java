package com.unisinos.petrinet.service;

import com.unisinos.petrinet.models.orderedArcs.AbstractOrderedArc;
import com.unisinos.petrinet.models.orderedArcs.PlaceToTransitionArc;
import com.unisinos.petrinet.models.Transition;
import com.unisinos.petrinet.models.orderedArcs.TransitionToPlaceArc;

import java.util.List;
import java.util.stream.Collectors;

public class TransitionCycleService extends AbstractCycleService <Transition> {

    public TransitionCycleService(Transition element) {
        super(element);
    }

    @Override
    void runCycle() {
        List<AbstractOrderedArc> arcs = getElement().getArcs();
        if(isAbleToRun(arcs)) {
            getSourceArcs(arcs).forEach(arc -> {
                arc.getPlace().setToken(arc.getPlace().getToken() - arc.getMultiplicity());
            });
            getDestinationArcs(arcs).forEach(arc -> {
                arc.getPlace().setToken(arc.getPlace().getToken() + arc.getMultiplicity());
            });
        }
    }

    private boolean isAbleToRun(List<AbstractOrderedArc> arcs) {
        return getSourceArcs(arcs).stream().allMatch(PlaceToTransitionArc::isAbleToRun);
    }

    private List<PlaceToTransitionArc> getSourceArcs(List<AbstractOrderedArc> arcs) {
        return arcs.stream().filter(abstractOrderedArc -> abstractOrderedArc instanceof PlaceToTransitionArc).map(arc -> (PlaceToTransitionArc)arc).collect(Collectors.toList());
    }

    private List<TransitionToPlaceArc> getDestinationArcs(List<AbstractOrderedArc> arcs) {
        return arcs.stream().filter(abstractOrderedArc -> abstractOrderedArc instanceof TransitionToPlaceArc).map(arc -> (TransitionToPlaceArc)arc).collect(Collectors.toList());
    }
}
