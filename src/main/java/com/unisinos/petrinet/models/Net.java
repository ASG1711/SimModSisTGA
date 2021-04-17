package com.unisinos.petrinet.models;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

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

    @Override
    public String toString() {
        return places.stream()
                .map(Object::toString)
                .reduce("Places: \n",(partial,place)-> partial + place)
                + "\n" +
                transitions.stream().map(Objects::toString)
                .reduce("Transitions: \n", (partial,transition) -> partial+transition);
    }
}
