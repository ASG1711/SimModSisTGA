package com.unisinos.petrinet.models;

import lombok.NonNull;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;

public class Place extends Spot {

    @Setter
    @NonNull
    private Marking marking;

    @XmlElement(name="initialMarking")
    public Marking getMarking() {
        return marking;
    }
}
