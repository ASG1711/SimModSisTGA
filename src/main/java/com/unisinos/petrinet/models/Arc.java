package com.unisinos.petrinet.models;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "arc")
public class Arc extends Element{

    @Setter
    private Element source;

    @Setter
    private Element destination;

    @Setter
    private Integer multiplicity;

    @Setter
    private ArcType type;

    @XmlIDREF
    @XmlElement(name="sourceId")
    public Element getSource() {
        return source;
    }

    @XmlIDREF
    @XmlElement(name="destinationId")
    public Element getDestination() {
        return destination;
    }

    @XmlElement(name="multiplicity")
    public Integer getMultiplicity() {
        return multiplicity;
    }

    @XmlElement(name="type")
    public ArcType getType() {
        return type;
    }
}
