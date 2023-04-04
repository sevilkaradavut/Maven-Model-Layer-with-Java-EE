package maven.personnelSystem.model.employee;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
		@NamedQuery(name = "Department.findByDepartmentName", query = "SELECT d.departmentName FROM Department d"),
		@NamedQuery(name = "Department.findLocationAndEmployeesByDepartmentId", query = "SELECT d FROM Department d LEFT OUTER JOIN FETCH d.location LEFT OUTER JOIN FETCH d.employees WHERE d.departmentId = :departmentId") })

public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")
	private Long departmentId;

	@Column
	private String departmentName;

	@ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", foreignKey = @ForeignKey(foreignKeyDefinition = "location_fk"))
	private Location location;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	private List<Employee> employees;

	public Department() {

	}

	public Department(String departmentName, Location location, List<Employee> employees) {
		this.departmentName = departmentName;
		this.location = location;
		this.employees = employees;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(departmentId, other.departmentId);
	}

}
