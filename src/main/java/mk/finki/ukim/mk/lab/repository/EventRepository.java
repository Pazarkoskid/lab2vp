package mk.finki.ukim.mk.lab.repository;


import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static mk.finki.ukim.mk.lab.bootstrap.DataHolder.events;

@Repository
public class EventRepository {
   public List<Event> findAll(){
       return events;
   }
   public List<Event> searchEvents(String text){
       return events.stream().filter(r->r.getName().contains(text) || r.getDescription().contains(text)).collect(Collectors.toList());
   }
    public List<Event> searchByScore(double score) {
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getPopularityScore() >= score) {
                result.add(event);
            }
        }
        return result;
    }
    public List<Event> searchByNameAndScore(String name, double score) {
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getName().toLowerCase().contains(name.toLowerCase()) && event.getPopularityScore() >= score) {
                result.add(event);
            }
        }
        return result;
    }

    public List<Event> searchByName(String name) {
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(event);
            }
        }
        return result;
    }

    public Event save(Event event) {
        events.removeIf(e -> e.getId().equals(event.getId())); // Update ако постои
        events.add(event);
        return event;
    }

    public Event findById(Long id) {
        return events.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteById(Long id) {
        events.removeIf(e -> e.getId().equals(id));
    }
}
