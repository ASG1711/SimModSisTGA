package com.unisinos.petrinet.models.orderedArcs;

import com.unisinos.petrinet.models.Arc;
import com.unisinos.petrinet.models.Place;
import com.unisinos.petrinet.models.Transition;

public abstract class AbstractOrderedArc extends Arc {
    public AbstractOrderedArc(Arc arc) {
        setSource(arc.getSource());
        setDestination(arc.getDestination());
        setMultiplicity(arc.getMultiplicity());
        setType(arc.getType());
    }

    abstract public Place getPlace();
    abstract public Transition getTransition();
    abstract public void move();
}
