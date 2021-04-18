package com.unisinos.petrinet.strategies.movement;

import com.unisinos.petrinet.models.orderedArcs.PlaceToTransitionArc;

public class RegularArcMovementStrategy implements ArcMovementStrategy{
    @Override
    public void move(PlaceToTransitionArc arc) {
        arc.getPlace().setToken(arc.getPlace().getToken() - arc.getMultiplicity());
    }
}
