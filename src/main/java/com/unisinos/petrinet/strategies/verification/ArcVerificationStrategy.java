package com.unisinos.petrinet.strategies.verification;

import com.unisinos.petrinet.models.orderedArcs.PlaceToTransitionArc;

public interface ArcVerificationStrategy {
    boolean isEnabled(PlaceToTransitionArc arc);
}
