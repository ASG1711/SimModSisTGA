package com.unisinos.petrinet.models;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "subnet")
public class Net extends Element{

    @Setter
    private List<Place> places;

    @Setter
    private List<Transition> transitions;

    @Setter
    private List<Arc> arcs;

    @XmlElement(name="place")
    public List<Place> getPlaces() {
        return places;
    }

    @XmlElement(name="transition")
    public List<Transition> getTransitions() {
        return transitions;
    }

    @XmlElement(name="arc")
    public List<Arc> getArcs() {
        return arcs;
    }

}
