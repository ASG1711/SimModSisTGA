package com.unisinos.petrinet.models;

import lombok.NonNull;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;

public class Spot {
    @Setter
    @NonNull
    private String id;

    @Setter
    @NonNull
    private Name name;

    @XmlAttribute
    @XmlID
    public String getId() {
        return id;
    }

    @XmlElement(name="name")
    public Name getName() {
        return name;
    }
}
