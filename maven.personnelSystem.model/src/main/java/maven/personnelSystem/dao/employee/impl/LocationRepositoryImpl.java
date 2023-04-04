package maven.personnelSystem.dao.employee.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import maven.personnelSystem.dao.employee.LocationRepository;
import maven.personnelSystem.model.employee.Location;

@Repository
@Transactional
public class LocationRepositoryImpl implements LocationRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean saveLocation(Location location) {
		entityManager.persist(location);
		return true;
	}

	@Override
	public boolean deleteLocation(Location location) {
		if (entityManager.contains(location)) {
			entityManager.remove(location);
			return true;
		}
		Location deleteLocation = findLocationById(location.getLocationId());
		entityManager.remove(deleteLocation);
		return true;
	}

	@Override
	public Location updateLocation(Location location) {
		Location updateLocation = entityManager.merge(location);
		entityManager.flush();
		return updateLocation;
	}

	@Override
	public Location findLocationById(Long locationId) {

		TypedQuery<Location> typedQuery = entityManager.createNamedQuery("Location.findLocationById", Location.class);
		typedQuery.setParameter("locationId", locationId);
		return typedQuery.getSingleResult();
	}

	@Override
	public List<Location> findAllLocations() {
		TypedQuery<Location> typedQuery = entityManager.createNamedQuery("Location.findAll", Location.class);
		return typedQuery.getResultList();
	}

}
