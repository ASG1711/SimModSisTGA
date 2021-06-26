package com.unisinos.petrinet.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "arc")
public class Arc extends Element{

    private Element source;

    private Element destination;

    private Integer multiplicity;

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

    public void setSource(Element source) {
        this.source = source;
    }

    public void setDestination(Element destination) {
        this.destination = destination;
    }

    public void setMultiplicity(Integer multiplicity) {
        this.multiplicity = multiplicity;
    }

    public void setType(ArcType type) {
        this.type = type;
    }
}
