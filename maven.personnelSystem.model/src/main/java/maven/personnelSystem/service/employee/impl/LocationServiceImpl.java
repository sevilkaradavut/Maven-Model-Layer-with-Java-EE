package maven.personnelSystem.service.employee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maven.personnelSystem.dao.employee.LocationRepository;
import maven.personnelSystem.model.employee.Location;
import maven.personnelSystem.service.employee.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public boolean saveLocation(Location location) {
		return locationRepository.saveLocation(location);
	}

	@Override
	public boolean deleteLocation(Location location) {
		return locationRepository.deleteLocation(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return locationRepository.updateLocation(location);
	}

	@Override
	public Location findLocationById(Long locationId) {
		return locationRepository.findLocationById(locationId);
	}

	@Override
	public List<Location> findAllLocations() {
		return locationRepository.findAllLocations();
	}

}
