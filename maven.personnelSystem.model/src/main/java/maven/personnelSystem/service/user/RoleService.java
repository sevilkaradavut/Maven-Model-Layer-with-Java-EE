package maven.personnelSystem.service.user;

import java.util.List;

import maven.personnelSystem.model.user.Role;

public interface RoleService {
	Role saveRole(Role role);

	Role updateRole(Role role);

	Role deleteRole(Role role);

	Role findRoleById(Long id);

	Role findRoleByName(String roleName);

	List<Role> findAllRoles();
}
