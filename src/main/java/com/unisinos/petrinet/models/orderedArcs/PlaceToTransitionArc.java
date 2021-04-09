package com.unisinos.petrinet.models.orderedArcs;

import com.unisinos.petrinet.models.Arc;
import com.unisinos.petrinet.models.Place;
import com.unisinos.petrinet.models.Transition;
import lombok.Getter;
import lombok.Setter;

public class PlaceToTransitionArc extends AbstractOrderedArc{
    @Getter
    @Setter
    private boolean isAbleToRun;

    public PlaceToTransitionArc(Arc arc) {
        super(arc);
        defineAbilityToRun();
    }

    private void defineAbilityToRun() {
        Integer availableTokens = getPlace().getToken();
        Integer arcCost = getMultiplicity();
        if(arcCost <= availableTokens) {
            setAbleToRun(true);
        }
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
