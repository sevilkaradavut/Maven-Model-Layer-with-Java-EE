package maven.personnelSystem.model.user;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "Privilege.findPrivilegeById", query = "SELECT p FROM Privilege p WHERE p.id = :privilegeId"),
		@NamedQuery(name = "Privilege.findPrivilegeByName", query = "SELECT p FROM Privilege p WHERE p.name = :privilegeName"),
		@NamedQuery(name = "Privilege.findAll", query = "SELECT p FROM Privilege p") })

public class Privilege {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "privilege_id")
	private Long id;

	@Column
	private String name;

	@ManyToMany(mappedBy = "privileges")
	private List<Role> roles;

	public Privilege() {

	}

	public Privilege(String name, List<Role> roles) {
		this.name = name;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Privilege other = (Privilege) obj;
		return Objects.equals(id, other.id);
	}

}
