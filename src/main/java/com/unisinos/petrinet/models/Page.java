package com.unisinos.petrinet.models;

import lombok.NonNull;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Page {
    @Setter
    @NonNull
    private String id;

    @Setter
    @NonNull
    private Name name;

    @Setter
    private List<Place> places;

    @Setter
    private List<Transition> transitions;

    @Setter
    private List<Arc> arcs;

    @XmlAttribute(name="id")
    public String getId() {
        return id;
    }

    @XmlElement(name="name")
    public Name getName() {
        return name;
    }

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
