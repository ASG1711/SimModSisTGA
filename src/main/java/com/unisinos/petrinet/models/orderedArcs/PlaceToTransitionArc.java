package com.unisinos.petrinet.models.orderedArcs;

import com.unisinos.petrinet.models.Arc;
import com.unisinos.petrinet.models.Place;
import com.unisinos.petrinet.models.Transition;
import com.unisinos.petrinet.strategies.movement.ArcMovementStrategy;
import com.unisinos.petrinet.strategies.movement.InhibitorArcMovementStrategy;
import com.unisinos.petrinet.strategies.movement.RegularArcMovementStrategy;
import com.unisinos.petrinet.strategies.movement.ResetArcMovementStrategy;
import com.unisinos.petrinet.strategies.verification.ArcVerificationStrategy;
import com.unisinos.petrinet.strategies.verification.InhibitorArcVerificationStrategy;
import com.unisinos.petrinet.strategies.verification.RegularArcVerificationStrategy;
import com.unisinos.petrinet.strategies.verification.ResetArcVerificationStrategy;

public class PlaceToTransitionArc extends AbstractOrderedArc{

    private ArcVerificationStrategy verificationStrategy;
    private ArcMovementStrategy movementStrategy;

    public PlaceToTransitionArc(Arc arc) {
        super(arc);
        setStrategies();
    }

    public boolean isEnabled() {
        return verificationStrategy.isEnabled(this);
    }

    public void move(){
        movementStrategy.move(this);
    }

    @Override
    public Place getPlace() {
        return (Place) getSource();
    }

    @Override
    public Transition getTransition() {
        return (Transition) getDestination();
    }

    private void setStrategies() {
        switch (getType()) {
            case REGULAR:
                verificationStrategy = new RegularArcVerificationStrategy();
                movementStrategy = new RegularArcMovementStrategy();
                break;
            case INHIBITOR:
                verificationStrategy = new InhibitorArcVerificationStrategy();
                movementStrategy = new InhibitorArcMovementStrategy();
                break;
            case RESET:
                verificationStrategy = new ResetArcVerificationStrategy();
                movementStrategy = new ResetArcMovementStrategy();
                break;
        }
    }

}
