package com.unisinos.petrinet.cycleservice;

import com.unisinos.petrinet.models.Document;
import com.unisinos.petrinet.models.Net;

import java.util.List;

public class DocumentCycleService extends AbstractCycleService <Document> {
    public DocumentCycleService(Document element) {
        super(element);
    }

    @Override
    public void runCycle(){

        List<Net> nets = getElement().getNets();
        nets.stream()
                .forEach(net -> new NetCycleService(net).runCycle());
    }
}
