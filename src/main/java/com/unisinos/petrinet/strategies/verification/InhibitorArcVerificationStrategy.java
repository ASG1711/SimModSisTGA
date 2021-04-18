package com.unisinos.petrinet.strategies.verification;

import com.unisinos.petrinet.models.orderedArcs.PlaceToTransitionArc;

public class InhibitorArcVerificationStrategy implements ArcVerificationStrategy{

    @Override
    public boolean isEnabled(PlaceToTransitionArc arc) {
        Integer availableTokens = arc.getPlace().getToken();
        Integer arcCost = arc.getMultiplicity();
        return arcCost > availableTokens;
    }
}
