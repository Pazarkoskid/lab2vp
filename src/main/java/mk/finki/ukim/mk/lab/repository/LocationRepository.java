package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LocationRepository {
    private final List<Location> locations;

    public LocationRepository() {
        locations = new ArrayList<>();
        locations.add(new Location(1L, "Мала сала", "Београдска 5", "100", "Концертна сала"));
        locations.add(new Location(2L, "Голема сала", "Нова 12", "500", "Конгресен центар"));
        locations.add(new Location(3L, "Сала 3", "Водно 34", "150", "Театар"));
        locations.add(new Location(4L, "Амфитеатар", "Центар 21", "200", "Отворен простор"));
        locations.add(new Location(5L, "Концертна сала", "Јужна 44", "300", "Концерт"));
    }

    public List<Location> findAll() {
        return locations;
    }

    public Location findById(Long id) {
        return locations.stream()
                .filter(location -> location.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
