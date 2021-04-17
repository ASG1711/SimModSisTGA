package com.unisinos.petrinet.strategies.verification;

import com.unisinos.petrinet.models.orderedArcs.PlaceToTransitionArc;

public class ResetArcVerificationStrategy implements ArcVerificationStrategy{
    @Override
    public boolean isEnabled(PlaceToTransitionArc arc) {
        return true;
    }
}
