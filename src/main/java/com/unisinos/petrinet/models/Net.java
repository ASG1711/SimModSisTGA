package com.unisinos.petrinet.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Net {

    @Getter @Setter
    @NonNull
    private String id;

    @Getter @Setter
    @NonNull
    @XmlElement
    private String name;

    @Getter @Setter
    @XmlElement(name = "page")
    private List<Page> pages = new ArrayList<Page>();
}
