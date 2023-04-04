package maven.personnelSystem.model.employee;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
		@NamedQuery(name = "Location.findLocationById", query = "SELECT l FROM Location l LEFT OUTER JOIN FETCH l.departments WHERE l.locationId = :locationId") })

public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "location_id", nullable = false, unique = true)
	private Long locationId;

	@Column(length = 50)
	private String address;

	@Column(name = "postalCode")
	private int postalCode;

	private String city;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
	private List<Department> departments;

	public Location() {
	}

	public Location(String address, int postalCode, String city) {
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(locationId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(locationId, other.locationId);
	}

}
