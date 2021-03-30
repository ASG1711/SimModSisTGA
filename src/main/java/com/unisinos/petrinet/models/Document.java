package com.unisinos.petrinet.models;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "pnml")
public class Document {
    @Getter
    @XmlElement(name = "net")
    private List<Net> nets = new ArrayList();
}
