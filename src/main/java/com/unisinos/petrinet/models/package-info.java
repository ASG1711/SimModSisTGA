@XmlSchema(
        namespace = Document.PNML_NAMESPACE,
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix = "", namespaceURI = Document.PNML_NAMESPACE)
        }
)
@XmlAccessorType(XmlAccessType.NONE)
package com.unisinos.petrinet.models;

import javax.xml.bind.annotation.*;