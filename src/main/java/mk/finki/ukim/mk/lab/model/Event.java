package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data

public class Event {
    private Long id;
    private String name;
    private String description;
    private Double popularityScore;
    private Location location;

    public Event(String name, String description, Double popularityScore, Location location) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location = location;
    }

    public Event() {}
}
