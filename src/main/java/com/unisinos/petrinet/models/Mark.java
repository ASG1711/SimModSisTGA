package com.unisinos.petrinet.models;

import lombok.NonNull;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;

public class Mark {
    @Setter
    @NonNull
    private Integer value;

    @XmlElement(name="text")
    public Integer getValue() {
        return value;
    }
}
