package com.unisinos.petrinet;

import org.junit.Test;

import javax.xml.bind.JAXBException;

public class PFLOWImporterTest {
    private PFLOWImporter importer = new PFLOWImporter();

    @Test
    public void importPNMLTest() throws JAXBException {
        importer.importPNML("simple_flow.pflow");
    }
}
