package com.unisinos.petrinet.models;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "place")
public class Place extends Element {

    @Setter
    private Integer token;

    @XmlElement(name="tokens")
    public Integer getToken() {
        return token;
    }

    @Override
    public String toString() {
        return String.format("ID: %s LABEL: %s MARCA: %s \n", getId(), getLabel(), getToken());
    }
}
