package com.unisinos.petrinet.models;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;

public class Element {

    @Setter
    private String id;

    @Setter
    private String label;

    @XmlID
    @XmlElement(name="id")
    public String getId() {
        return id;
    }

    @XmlElement(name = "label")
    public String getLabel() {
        return label;
    }
}
