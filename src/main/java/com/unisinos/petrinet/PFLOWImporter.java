package com.unisinos.petrinet;

import com.unisinos.petrinet.models.*;
import com.unisinos.petrinet.models.orderedArcs.PlaceToTransitionArc;
import com.unisinos.petrinet.models.orderedArcs.TransitionToPlaceArc;
import com.unisinos.petrinet.service.DocumentCycleService;

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
        populateDocumentTransitions(document);

        DocumentCycleService cycleService = new DocumentCycleService(document);
        cycleService.runCycle();
        return document;
    }

    private String getResourceFile(String filePath) {
        return PFLOWImporter.class.getClassLoader().getResource(filePath).getFile();
    }

    private void populateDocumentTransitions(Document document) {
        document.getNets().forEach(this::populateTransitionsWithArcs);
    }

    private void populateTransitionsWithArcs(Net net) {
        net.getArcs().forEach(this::addArcToTransition);
    }

    private void addArcToTransition(com.unisinos.petrinet.models.Arc arc) {
        if (arc.getDestination() instanceof Transition) ((Transition) arc.getDestination()).getArcs().add(new PlaceToTransitionArc(arc));
        if (arc.getSource() instanceof Transition) ((Transition) arc.getSource()).getArcs().add(new TransitionToPlaceArc(arc));
    }

}
