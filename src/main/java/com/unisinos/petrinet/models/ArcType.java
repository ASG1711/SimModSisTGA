package com.unisinos.petrinet.models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum ArcType {
    @XmlEnumValue("regular")
    REGULAR,

    @XmlEnumValue("inhibitor")
    INHIBITOR,

    @XmlEnumValue("reset")
    RESET;
}
