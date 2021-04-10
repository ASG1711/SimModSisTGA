package com.unisinos.petrinet.models.orderedArcs;

import com.unisinos.petrinet.models.Arc;
import com.unisinos.petrinet.models.Place;
import com.unisinos.petrinet.models.Transition;

public class PlaceToTransitionArc extends AbstractOrderedArc{

    public PlaceToTransitionArc(Arc arc) {
        super(arc);
    }

    public boolean isEnabled() {
        Integer availableTokens = getPlace().getToken();
        Integer arcCost = getMultiplicity();
        return arcCost <= availableTokens;
    }

    @Override
    public Place getPlace() {
        return (Place) getSource();
    }

    @Override
    public Transition getTransition() {
        return (Transition) getDestination();
    }
}
