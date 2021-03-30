package com.unisinos.petrinet.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;

public class Transition {

    @Getter @Setter
    @NonNull
    private String id;

    @Getter @Setter
    @NonNull
    @XmlElement
    private String name;

    @Getter @Setter
    private Integer marks;
}
