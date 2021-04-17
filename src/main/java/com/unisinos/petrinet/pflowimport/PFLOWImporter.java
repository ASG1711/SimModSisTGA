package com.unisinos.petrinet.pflowimport;

import com.unisinos.petrinet.models.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class PFLOWImporter {
    private DocumentTransitionsPopulator documentTransitionsPopulator = new DocumentTransitionsPopulator();

    public Document importPNML(String filePath) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Document.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File resource = new File(getResourceFile(filePath));
        Document document = (Document) unmarshaller.unmarshal(resource);
        documentTransitionsPopulator.populate(document);
        return document;
    }

    private String getResourceFile(String filePath) {
        return PFLOWImporter.class.getClassLoader().getResource(filePath).getFile();
    }


}
