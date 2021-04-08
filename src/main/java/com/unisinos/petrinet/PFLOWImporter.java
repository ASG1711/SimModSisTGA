package com.unisinos.petrinet;

import com.unisinos.petrinet.models.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class PFLOWImporter {
    public Document importPNML(String filePath) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Document.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File resource = new File(getResourceFile(filePath));
        Document document = (Document) unmarshaller.unmarshal(resource);
        return document;
    }

    private String getResourceFile(String filePath) {
        return PFLOWImporter.class.getClassLoader().getResource(filePath).getFile();
    }
}
