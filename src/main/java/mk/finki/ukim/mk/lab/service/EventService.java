package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;

import java.util.List;

public interface EventService {
    List<Event> listAll();
    List<Event> searchByName(String text);
    List<Event> searchByScore(double score);
    List<Event> searchByNameAndScore(String text,double score);

    Event save(String name, String description, double popularityScore, Location location);
    Event findById(Long id);
    Event update(Long id, String name, String description, double popularityScore, Location location);
    void delete(Long id);


}