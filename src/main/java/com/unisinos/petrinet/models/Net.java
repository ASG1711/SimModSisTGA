package com.unisinos.petrinet.models;

import lombok.NonNull;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "net")
public class Net {

    @Setter
    @NonNull
    private String id;

    @Setter
    private Name name;

    @Setter
    private List<Page> pages;

    @XmlAttribute(name="id")
    public String getId() {
        return id;
    }

    @XmlElement(name="name")
    public Name getName() {
        return name;
    }

    @XmlElement(name="page")
    public List<Page> getPages() {
        return pages;
    }

}
