package com.unisinos.petrinet;

import org.junit.Test;

import javax.xml.bind.JAXBException;

public class PNMLImporterTest {
    private PNMLImporter importer = new PNMLImporter();

    @Test
    public void importPNMLTest() throws JAXBException {
        importer.importPNML("philo.pnml");
    }
}
