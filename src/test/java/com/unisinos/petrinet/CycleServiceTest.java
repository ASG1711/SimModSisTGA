package com.unisinos.petrinet;

import com.unisinos.petrinet.cycleservice.DocumentCycleService;
import com.unisinos.petrinet.models.Document;
import com.unisinos.petrinet.pflowimport.PFLOWImporter;
import org.junit.Test;

import javax.xml.bind.JAXBException;

public class CycleServiceTest {
    public static final int CICLOS = 5;
    private PFLOWImporter importer = new PFLOWImporter();
    private DocumentCycleService cycleService;

    @Test
    public void runFullCycle() throws JAXBException {
        Document document = importer.importPNML("simple_flow.pflow");
        cycleService = new DocumentCycleService(document);
        System.out.println("Importado: \n");
        System.out.println(document.toString());
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < CICLOS; i++) {
            cycleService.runCycle();
            System.out.println("Ciclo " + i + ": \n");
            System.out.println(document.toString());
            System.out.println("----------------------------------------------------------");
        }
    }
}
