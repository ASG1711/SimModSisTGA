package com.unisinos.petrinet.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;

public class Element {

    private String id;

    private String label;

    @XmlID
    @XmlElement(name="id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @XmlElement(name = "label")
    public String getLabel() {
        return label;
    }
}
