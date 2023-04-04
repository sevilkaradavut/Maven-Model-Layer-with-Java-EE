package maven.personnelSystem.dao.user.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import maven.personnelSystem.dao.user.PasswordResetTokenRepository;
import maven.personnelSystem.model.user.PasswordResetToken;
import maven.personnelSystem.model.user.User;

@Repository
@Transactional
public class PasswordResetTokenRepositoryImp implements PasswordResetTokenRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public PasswordResetToken savePasswordResetToken(PasswordResetToken passwordResetToken) {
		entityManager.persist(passwordResetToken);
		return passwordResetToken;
	}

	@Override
	public PasswordResetToken updatePasswordResetToken(PasswordResetToken passwordResetToken) {
		PasswordResetToken updatePasswordResetToken = entityManager.merge(passwordResetToken);
		entityManager.flush();
		return updatePasswordResetToken;
	}

	@Override
	public PasswordResetToken deletePasswordResetToken(PasswordResetToken passwordResetToken) {
		if (entityManager.contains(passwordResetToken)) {
			entityManager.remove(passwordResetToken);
			return passwordResetToken;
		}
		PasswordResetToken deletePasswordResetToken = findPasswordResetTokenById(passwordResetToken.getId());
		entityManager.remove(deletePasswordResetToken);
		return deletePasswordResetToken;
	}

	@Override
	public PasswordResetToken findPasswordResetTokenByToken(String token) {
		TypedQuery<PasswordResetToken> typedQuery = entityManager.createNamedQuery("PasswordResetToken.findByToken",
				PasswordResetToken.class);
		typedQuery.setParameter("token", token);
		return typedQuery.getSingleResult();
	}

	@Override
	public PasswordResetToken findPasswordResetTokenByUser(User user) {
		TypedQuery<PasswordResetToken> typedQuery = entityManager.createNamedQuery("PasswordResetToken.findByUserId",
				PasswordResetToken.class);
		typedQuery.setParameter("userId", user.getId());
		return typedQuery.getSingleResult();
	}

	@Override
	public PasswordResetToken findPasswordResetTokenById(Long id) {
		PasswordResetToken findPasswordResetTokenById = entityManager.find(PasswordResetToken.class, id);
		return findPasswordResetTokenById;
	}

	@Override
	public List<PasswordResetToken> findAllByExpiryDateLessThan(Date date) {
		TypedQuery<PasswordResetToken> typedQuery = entityManager
				.createNamedQuery("PasswordResetToken.findAllByExpiryDateLessThan", PasswordResetToken.class);
		typedQuery.setParameter("expiryDate", date, TemporalType.TIMESTAMP);
		return typedQuery.getResultList();
	}

}
