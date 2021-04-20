package com.unisinos.petrinet;

import com.unisinos.petrinet.models.Document;
import com.unisinos.petrinet.models.Transition;
import com.unisinos.petrinet.pflowimport.PFLOWImporter;
import com.unisinos.petrinet.services.CycleService;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;

public class CycleServiceTest {
    public static final Integer SIMPLE_FLOW_FULL_CYCLE = 3;
    public static final Integer INHIBITOR_FULL_CYCLE = 4;
    public static final Integer NO_TOKEN = 0;

    private final CycleService cycleService = new CycleService();
    private final PFLOWImporter importer = new PFLOWImporter();

    @Test
    public void runSimpleFlowFullCycleTest() throws JAXBException {
        Document document = importer.importPNML("simple_flow.pflow");
        cycleService.runCycles(document, SIMPLE_FLOW_FULL_CYCLE);
        Transition transition4 = document.getNets().get(0).getTransitions().get(1);
        Assert.assertTrue(transition4.isEnabled());
    }

    @Test
    public void runInhibitorCycleTest() throws JAXBException {
        Document document = importer.importPNML("inhibitor.pflow");
        Integer totalCycles = cycleService.getCyclesQuantityToFinish(document);
        Assert.assertEquals(INHIBITOR_FULL_CYCLE, totalCycles);
    }

    @Test
    public void runResetCycleTest() throws JAXBException {
        Document document = importer.importPNML("reset.pflow");
        cycleService.runCycles(document, 1);
        Integer firstPlaceTokens = document.getNets().get(0).getPlaces().get(0).getToken();
        Integer secondPlaceTokens = document.getNets().get(0).getPlaces().get(1).getToken();
        Assert.assertEquals(NO_TOKEN, firstPlaceTokens);
        Assert.assertEquals(Integer.valueOf(1), secondPlaceTokens);
    }

    @Test
    public void runTransitionConsumptionLoopTest() throws JAXBException {
        Document document = importer.importPNML("full_places_consumption.pflow");
        Integer totalCycles = cycleService.getCyclesQuantityToFinish(document);
        Assert.assertEquals(Integer.valueOf(1), totalCycles);
    }
}
