package com.unisinos.petrinet;

import com.unisinos.petrinet.models.Document;
import com.unisinos.petrinet.pflowimport.PFLOWImporter;
import org.junit.Test;

import javax.xml.bind.JAXBException;

public class PFLOWImporterTest {
    private final PFLOWImporter importer = new PFLOWImporter();

    @Test
    public void importPNMLTest() throws JAXBException {
        Document document = importer.importPflow("exemplo_enunciado.pflow");
    }
}
