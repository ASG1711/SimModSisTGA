package com.unisinos.petrinet.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "place")
public class Place extends Element {

    private Integer token;

    @XmlElement(name="tokens")
    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return String.format("ID: %s LABEL: %s MARCA: %s \n", getId(), getLabel(), getToken());
    }
}
