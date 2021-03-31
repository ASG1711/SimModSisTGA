package com.unisinos.petrinet.models;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "pnml")
public class Document {
    public static final String PNML_NAMESPACE = "http://www.pnml.org/version-2009/grammar/pnml";

    @Setter
    private List<Net> nets;

    @XmlElement(name = "net")
    public List<Net> getNets() {
        return nets;
    }
}
