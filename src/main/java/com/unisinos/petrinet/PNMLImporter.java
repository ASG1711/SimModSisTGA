package com.unisinos.petrinet;

import com.unisinos.petrinet.models.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class PNMLImporter {
    public Document importPNML(String filePath) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Document.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File resource = new File(getResourceFile(filePath));
        return (Document) unmarshaller.unmarshal(resource);
    }

    private String getResourceFile(String filePath) {
        return PNMLImporter.class.getClassLoader().getResource(filePath).getFile();
    }
}
