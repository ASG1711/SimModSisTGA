package com.unisinos.petrinet.models;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "document")
public class Document extends Element{

    @Setter
    private List<Net> nets;

    @XmlElement(name = "subnet")
    public List<Net> getNets() {
        return nets;
    }


}
