package com.unisinos.petrinet.models.orderedArcs;

import com.unisinos.petrinet.models.Arc;
import com.unisinos.petrinet.models.Place;
import com.unisinos.petrinet.models.Transition;

public class TransitionToPlaceArc extends AbstractOrderedArc{

    public TransitionToPlaceArc(Arc arc) {
        super(arc);
    }

    @Override
    public Place getPlace() {
        return (Place) getDestination();
    }

    @Override
    public Transition getTransition() {
        return (Transition) getSource();
    }
}
