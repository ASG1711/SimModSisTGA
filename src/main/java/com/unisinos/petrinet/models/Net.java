package com.unisinos.petrinet.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "subnet")
public class Net extends Element{

    private List<Place> places;

    private List<Transition> transitions;

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

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

    public void setArcs(List<Arc> arcs) {
        this.arcs = arcs;
    }

    @Override
    public String toString() {
        return places.stream()
                .map(Place::toString)
                .reduce("Places: \n",(partial,place)-> partial + place)
                + "\n" +
                transitions.stream().map(Transition::toString)
                .reduce("Transitions: \n", (partial,transition) -> partial+transition);
    }
}
