package com.unisinos.petrinet;

import com.unisinos.petrinet.models.Document;
import com.unisinos.petrinet.pflowimport.PFLOWImporter;
import com.unisinos.petrinet.services.CycleService;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;

public class PresentationTest {
    public static final Integer REQUISITE_EXAMPLE_FULL_CYCLE = 7;

    private final CycleService cycleService = new CycleService();
    private final PFLOWImporter importer = new PFLOWImporter();

    @Test
    public void runRequisitesExample() throws JAXBException {
        Document document = importer.importPflow("exemplo_enunciado.pflow");
        Integer totalCycles = cycleService.getCyclesQuantityToFinish(document);
        Assert.assertEquals(REQUISITE_EXAMPLE_FULL_CYCLE, totalCycles);
    }
}
