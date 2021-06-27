package com.unisinos.petrinet.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Optional;

@XmlRootElement(name = "document")
public class Document extends Element{

    private List<Net> nets;

    private boolean finished;

    @XmlElement(name = "subnet")
    public List<Net> getNets() {
        return nets;
    }

    public void setNets(List<Net> nets) {
        this.nets = nets;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Place getPlaceById(String id){
        Optional<Optional<Place>> optionalPlace = getNets()
                .stream()
                .map(Net::getPlaces)
                .map(places -> places
                        .stream()
                        .filter(place -> place.getId().equals(id))
                        .findFirst()).findFirst();
        if(optionalPlace.isPresent() && optionalPlace.get().isPresent()){
            return optionalPlace.get().get();
        }
        return null;
    }

    public void resetTransitionsStatus(){
        getNets()
            .forEach(net -> net.getTransitions()
                .forEach(Transition::setEnabledVerifyingArcs));
    }

    public void setPlaceTokenById(String id, int tokens) {
        Place placeById = getPlaceById(id);
        placeById.setToken(tokens);
        resetTransitionsStatus();
        finished = false;
    }

    @Override
    public String toString() {
        return nets.stream()
                .map(Net::toString)
                .reduce("",(partial, net) -> partial + net);
    }
}
