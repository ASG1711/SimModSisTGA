package com.unisinos.petrinet;

import com.unisinos.petrinet.services.CycleService;
import com.unisinos.petrinet.models.Document;
import com.unisinos.petrinet.models.Transition;
import com.unisinos.petrinet.pflowimport.PFLOWImporter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;

public class CycleServiceTest {
    public static final Integer SIMPLE_FLOW_FULL_CYCLE = 3;
    public static final Integer INHIBITOR_FULL_CYCLE = 5;
    public static final Integer NO_TOKEN = 0;
    private PFLOWImporter importer;
    private CycleService cycleService;

    @Before
    public void setUp() {
        importer = new PFLOWImporter();
        cycleService = new CycleService();
    }

    @Test
    public void runSimpleFlowFullCycleTest() throws JAXBException {
        Document document = importDocument("simple_flow.pflow");
        runCycles(document, SIMPLE_FLOW_FULL_CYCLE);
        Transition transition4 = document.getNets().get(0).getTransitions().get(1);
        Assert.assertTrue(transition4.isEnabled());
    }

    @Test
    public void runInhibitorCycleTest() throws JAXBException {
        Document document = importDocument("inhibitor.pflow");
        runCycles(document, INHIBITOR_FULL_CYCLE);
        Assert.assertTrue(areTransitionsDisabled(document));
    }

    @Test
    public void runResetCycleTest() throws JAXBException {
        Document document = importDocument("reset.pflow");
        runCycles(document, 1);
        Integer firstPlaceTokens = document.getNets().get(0).getPlaces().get(0).getToken();
        Integer secondPlaceTokens = document.getNets().get(0).getPlaces().get(1).getToken();
        Assert.assertEquals(NO_TOKEN, firstPlaceTokens);
        Assert.assertEquals(Integer.valueOf(1), secondPlaceTokens);
    }

    @Test
    public void runTransitionConsumptionLoopTest() throws JAXBException {
        Document document = importDocument("full_places_consumption.pflow");
        runCycles(document, 1);
        Integer firstBaseTokens = document.getNets().get(0).getPlaces().get(0).getToken();
        Assert.assertEquals(NO_TOKEN, firstBaseTokens);
    }

    private void runCycles(Document document, Integer cycles) {
        for (int i = 0; i < cycles; i++) {
            cycleService.runCycle(document);
            System.out.println("Ciclo " + i + ": \n");
            System.out.println(document.toString());
            System.out.println("----------------------------------------------------------");
        }
    }

    private Document importDocument(String path) throws JAXBException {
        Document document = importer.importPNML(path);
        System.out.println("Importado: \n");
        System.out.println(document.toString());
        System.out.println("----------------------------------------------------------");
        return document;
    }

    private boolean areTransitionsDisabled(Document document) {
        return document.getNets().get(0).getTransitions().stream().noneMatch(Transition::isEnabled);
    }
}
