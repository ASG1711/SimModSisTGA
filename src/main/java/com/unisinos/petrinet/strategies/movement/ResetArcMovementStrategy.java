package com.unisinos.petrinet.strategies.movement;

import com.unisinos.petrinet.models.orderedArcs.PlaceToTransitionArc;

public class ResetArcMovementStrategy implements ArcMovementStrategy{
    public static final int NO_TOKENS = 0;

    @Override
    public void move(PlaceToTransitionArc arc) {
        arc.getPlace().setToken(NO_TOKENS);
    }
}
