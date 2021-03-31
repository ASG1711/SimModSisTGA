package com.unisinos.petrinet.models;

import lombok.NonNull;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "arc")
public class Arc {

    @Setter
    @NonNull
    private String id;

    @Setter
    @NonNull
    private Spot source;

    @Setter
    @NonNull
    private Spot target;

    @Setter
    @NonNull
    private Inscription inscription;

    @XmlAttribute(name="id")
    public String getId() {
        return id;
    }

    @XmlIDREF
    @XmlAttribute(name="source", required = true)
    public Spot getSource() {
        return source;
    }

    @XmlIDREF
    @XmlAttribute(name="target", required = true)
    public Spot getTarget() {
        return target;
    }

    @XmlElement(name="inscription")
    public Inscription getInscription() {
        return inscription;
    }
}
