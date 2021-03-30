package com.unisinos.petrinet.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Page {

    @Getter @Setter
    @NonNull
    private String id;

    @Getter @Setter
    @NonNull
    @XmlElement
    private String name;

    @Getter @Setter
    @XmlElement(name = "place")
    private List<Place> places = new ArrayList<Place>();

    @Getter @Setter
    @XmlElement(name = "transition")
    private List<Transition> transitions = new ArrayList<Transition>();

    @Getter @Setter
    @XmlElement(name = "arc")
    private List<Arc> arcs = new ArrayList<Arc>();
}
