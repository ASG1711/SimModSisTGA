package com.unisinos.petrinet;

import com.unisinos.petrinet.models.Document;
import com.unisinos.petrinet.pflowimport.PFLOWImporter;
import com.unisinos.petrinet.services.CycleService;
import org.junit.Test;

import javax.xml.bind.JAXBException;

public class PresentationTest {
    public static final int REQUISITE_EXAMPLE_FULL_CYCLE = 7;

    private final CycleService cycleService = new CycleService();
    private final PFLOWImporter importer = new PFLOWImporter();

    @Test
    public void runRequisitesExample() throws JAXBException {
        Document document = importer.importPNML("exemplo_enunciado.pflow");
        cycleService.runCycles(document, REQUISITE_EXAMPLE_FULL_CYCLE);
    }
}