package maven.personnelSystem.service.employee;

import java.util.List;

import maven.personnelSystem.model.employee.Location;

public interface LocationService {
	boolean saveLocation(Location location);

	boolean deleteLocation(Location location);

	Location updateLocation(Location location);

	Location findLocationById(Long locationId);

	List<Location> findAllLocations();
}
