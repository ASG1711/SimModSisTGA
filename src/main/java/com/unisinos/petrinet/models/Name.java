package com.unisinos.petrinet.models;

import lombok.NonNull;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "name")
public class Name {
    @Setter
    @NonNull
    private String text;

    @XmlElement(name="text")
    public String getText() {
        return text;
    }
}
