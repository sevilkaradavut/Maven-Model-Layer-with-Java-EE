package maven.personnelSystem.dao.user.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import maven.personnelSystem.dao.user.VerificationTokenRepository;
import maven.personnelSystem.model.user.User;
import maven.personnelSystem.model.user.VerificationToken;

@Repository
@Transactional
public class VerificationTokenRepositoryImpl implements VerificationTokenRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public VerificationToken saveVerificationToken(VerificationToken verificationToken) {
		entityManager.persist(verificationToken);
		return verificationToken;
	}

	@Override
	public VerificationToken updateVerificationToken(VerificationToken verificationToken) {
		VerificationToken updateVerificationToken = entityManager.merge(verificationToken);
		entityManager.flush();
		return updateVerificationToken;
	}

	@Override
	public VerificationToken deleteVerificationToken(VerificationToken verificationToken) {
		if (entityManager.contains(verificationToken)) {
			entityManager.remove(verificationToken);
			return verificationToken;
		}
		VerificationToken deleteVerificationToken = findVerificationTokenById(verificationToken.getId());
		entityManager.remove(deleteVerificationToken);
		return deleteVerificationToken;
	}

	@Override
	public VerificationToken findVerificationTokenByToken(String token) {
		TypedQuery<VerificationToken> typedQuery = entityManager.createNamedQuery("VerificationToken.findByToken",
				VerificationToken.class);
		typedQuery.setParameter("token", token);
		return typedQuery.getSingleResult();
	}

	@Override
	public VerificationToken findVerificationTokenByUser(User user) {

		TypedQuery<VerificationToken> typedQuery = entityManager.createNamedQuery("VerificationToken.findByUserId",
				VerificationToken.class);
		typedQuery.setParameter("userId", user.getId());
		return typedQuery.getSingleResult();
	}

	@Override
	public List<VerificationToken> findAllByExpiryDateLessThan(Date date) {
		TypedQuery<VerificationToken> typedQuery = entityManager
				.createNamedQuery("VerificationToken.findAllByExpiryDateLessThan", VerificationToken.class);
		typedQuery.setParameter("expiryDate", date, TemporalType.TIMESTAMP);
		return typedQuery.getResultList();
	}

	@Override
	public VerificationToken findVerificationTokenById(Long id) {

		return entityManager.find(VerificationToken.class, id);
	}

}
