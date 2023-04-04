package maven.personnelSystem.dao.user;

import java.util.List;

import maven.personnelSystem.model.user.Role;

public interface RoleRepository {

	Role saveRole(Role role);

	Role updateRole(Role role);

	Role deleteRole(Role role);

	Role findRoleById(Long id);

	Role findRoleByName(String roleName);

	List<Role> findAllRoles();
}
