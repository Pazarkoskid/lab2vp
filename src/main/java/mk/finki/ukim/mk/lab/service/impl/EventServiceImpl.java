package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.EventRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(){
        eventRepository = new EventRepository();
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchByName(String text) {
        return eventRepository.searchByName(text);
    }

    @Override
    public List<Event> searchByScore(double score) {
        return eventRepository.searchByScore(score);
    }

    @Override
    public List<Event> searchByNameAndScore(String text,double score) {
        return eventRepository.searchByNameAndScore(text,score);
    }

    @Override
    public Event save(String name, String description, double popularityScore, Location location) {
        Event event = new Event(name, description, popularityScore, location);
        return eventRepository.save(event);
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id);
    }



    @Override
    public Event update(Long id, String name, String description, double popularityScore, Location location) {
        Event event = eventRepository.findById(id);
        if (event != null) {
            event.setName(name);
            event.setDescription(description);
            event.setPopularityScore(popularityScore);
            event.setLocation(location);
            eventRepository.save(event);
        }
        return event;
    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
