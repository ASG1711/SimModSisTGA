package com.unisinos.petrinet.strategies.movement;

import com.unisinos.petrinet.models.orderedArcs.PlaceToTransitionArc;

public interface ArcMovementStrategy {
    void move(PlaceToTransitionArc arc);
}
