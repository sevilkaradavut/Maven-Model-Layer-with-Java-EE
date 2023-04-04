package maven.personnelSystem.dao.user.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import maven.personnelSystem.dao.user.PrivilegeRepository;
import maven.personnelSystem.model.user.Privilege;

@Repository
@Transactional
public class PrivilegeRepositoryImpl implements PrivilegeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Privilege savePrivilege(Privilege privilege) {
		entityManager.persist(privilege);
		return privilege;
	}

	@Override
	public Privilege updatePrivilege(Privilege privilege) {
		Privilege updatePrivilege = entityManager.merge(privilege);
		entityManager.flush();
		return updatePrivilege;
	}

	@Override
	public Privilege deletePrivilege(Privilege privilege) {

		if (entityManager.contains(privilege)) {
			entityManager.remove(privilege);
			return privilege;
		}

		Privilege deletePrivilege = findPrivilegeById(privilege.getId());
		entityManager.remove(deletePrivilege);
		return deletePrivilege;
	}

	@Override
	public Privilege findPrivilegeById(Long id) {
		TypedQuery<Privilege> typedQuery = entityManager.createNamedQuery("Privilege.findPrivilegeById",
				Privilege.class);
		typedQuery.setParameter("privilegeId", id);
		return typedQuery.getSingleResult();
	}

	@Override
	public Privilege findPrivilegeByName(String privilegeName) {

		TypedQuery<Privilege> typedQuery = entityManager.createNamedQuery("Privilege.findPrivilegeByName",
				Privilege.class);
		typedQuery.setParameter("privilegeName", privilegeName);
		return typedQuery.getSingleResult();
	}

	@Override
	public List<Privilege> findAllPrivileges() {
		TypedQuery<Privilege> typedQuery = entityManager.createNamedQuery("Privilege.findAll", Privilege.class);
		return typedQuery.getResultList();
	}

}
