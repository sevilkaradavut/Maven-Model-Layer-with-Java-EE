package maven.personnelSystem.dao.user.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import maven.personnelSystem.dao.user.RoleRepository;
import maven.personnelSystem.model.user.Role;

@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Role saveRole(Role role) {
		entityManager.persist(role);
		return role;
	}

	@Override
	public Role updateRole(Role role) {
		Role updateRole = entityManager.merge(role);
		return updateRole;
	}

	@Override
	public Role deleteRole(Role role) {
		if (entityManager.contains(role)) {
			entityManager.remove(role);
			return role;
		}
		Role deleteRole = findRoleById(role.getId());
		entityManager.remove(deleteRole);
		return deleteRole;
	}

	@Override
	public Role findRoleById(Long id) {
		TypedQuery<Role> typedQuery = entityManager.createNamedQuery("Role.findRoleById", Role.class);
		typedQuery.setParameter("roleId", id);
		return typedQuery.getSingleResult();
	}

	@Override
	public Role findRoleByName(String roleName) {
		TypedQuery<Role> typedQuery = entityManager.createNamedQuery("Role.findRoleByName", Role.class);
		typedQuery.setParameter("roleName", roleName);
		return typedQuery.getSingleResult();
	}

	@Override
	public List<Role> findAllRoles() {
		TypedQuery<Role> typedQuery = entityManager.createNamedQuery("Role.findAll", Role.class);
		return typedQuery.getResultList();
	}

}
