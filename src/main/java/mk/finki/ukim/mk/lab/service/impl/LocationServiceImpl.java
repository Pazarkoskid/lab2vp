package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.LocationRepository;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl() {
        this.locationRepository = new LocationRepository();
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }
    @Override
    public Location findById(Location id) {
        return locationRepository.findById(id.getId());
    }

}
