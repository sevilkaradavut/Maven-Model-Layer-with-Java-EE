package maven.personnelSystem.dao.user.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import maven.personnelSystem.dao.user.UserRepository;
import maven.personnelSystem.model.user.User;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User saveUser(User user) {
		entityManager.persist(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		User updateUser = entityManager.merge(user);
		entityManager.flush();
		return updateUser;
	}

	@Override
	public User deleteUser(User user) {
		if (entityManager.contains(user)) {
			entityManager.remove(user);
			return user;
		}
		User deleteUser = findUserById(user.getId());
		entityManager.remove(deleteUser);
		return deleteUser;
	}

	@Override
	public User findUserById(Long id) {
		TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findUserById", User.class);
		typedQuery.setParameter("userId", id);
		return typedQuery.getSingleResult();
	}

	@Override
	public User findUserByUsername(String username) {
		TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findUserByUsername", User.class);
		typedQuery.setParameter("username", username);
		return typedQuery.getSingleResult();
	}

	@Override
	public User findUserByEmail(String email) {
		TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findUserByEmail", User.class);
		typedQuery.setParameter("userEmail", email);
		return typedQuery.getSingleResult();
	}

	@Override
	public List<User> findAllUsers() {
		TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findAll", User.class);
		return typedQuery.getResultList();
	}

}
