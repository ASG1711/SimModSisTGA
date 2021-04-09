package com.unisinos.petrinet.models;

import com.unisinos.petrinet.models.orderedArcs.AbstractOrderedArc;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "transition")
public class Transition extends Element {
    @Setter
    @Getter
    private List<AbstractOrderedArc> arcs = new ArrayList<>();
}
