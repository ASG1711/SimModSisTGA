package com.unisinos.petrinet.cycleservice;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractCycleService <T>{
    @Setter
    @Getter
    private T element;

    public AbstractCycleService(T element) {
        this.element = element;
    }

    abstract void runCycle();
}
