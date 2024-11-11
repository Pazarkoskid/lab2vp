package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.LocationRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event>events=new ArrayList<>();
    private final LocationRepository locationRepository ;


    public DataHolder(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    @PostConstruct
    public void init(){
        List<Location> allLocations = locationRepository.findAll();
        events.add(new Event("Event 1","Discription for event 1", 9.0,allLocations.get(0)));
        events.add(new Event("Event 2","Discription for event 2",6.5,allLocations.get(1)));
        events.add(new Event("Event 3","Discription for event 3",4.5,allLocations.get(2)));
        events.add(new Event("Event 4","Discription for event 4",8.0, allLocations.get(3)));
        events.add(new Event("Event 5","Discription for event 5",10.0, allLocations.get(4)));
        events.add(new Event("Event 6","Discription for event 6",2.0, allLocations.get(5)));
        events.add(new Event("Event 7","Discription for event 7",9.9, allLocations.get(6)));
        events.add(new Event("Event 8","Discription for event 8",5.5, allLocations.get(7)));
        events.add(new Event("Event 9","Discription for event 9",3.8, allLocations.get(8)));
        events.add(new Event("Event 10","Discription for event 10",8.7, allLocations.get(9)));
    }
}