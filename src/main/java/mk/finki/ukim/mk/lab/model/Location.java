package mk.finki.ukim.mk.lab.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Location {
    private Long id;
    private String name;
    private String address;
    private String capacity;
    private String description;
    public Location(Long id, String name, String address, String capacity, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.description = description;
    }
}
