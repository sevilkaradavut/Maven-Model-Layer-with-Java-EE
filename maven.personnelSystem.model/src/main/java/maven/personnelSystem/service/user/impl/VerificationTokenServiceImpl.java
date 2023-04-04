package maven.personnelSystem.service.user.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maven.personnelSystem.dao.user.VerificationTokenRepository;
import maven.personnelSystem.model.user.User;
import maven.personnelSystem.model.user.VerificationToken;
import maven.personnelSystem.service.user.VerificationTokenService;

@Service
public class VerificationTokenServiceImpl implements VerificationTokenService {

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Override
	public VerificationToken saveVerificationToken(VerificationToken verificationToken) {
		return verificationTokenRepository.saveVerificationToken(verificationToken);
	}

	@Override
	public VerificationToken updateVerificationToken(VerificationToken verificationToken) {
		return verificationTokenRepository.updateVerificationToken(verificationToken);
	}

	@Override
	public VerificationToken deleteVerificationToken(VerificationToken verificationToken) {
		return verificationTokenRepository.deleteVerificationToken(verificationToken);
	}

	@Override
	public VerificationToken findVerificationTokenByToken(String token) {
		return verificationTokenRepository.findVerificationTokenByToken(token);
	}

	@Override
	public VerificationToken findVerificationTokenByUser(User user) {
		return verificationTokenRepository.findVerificationTokenByUser(user);
	}

	@Override
	public VerificationToken findVerificationTokenById(Long id) {
		return verificationTokenRepository.findVerificationTokenById(id);
	}

	@Override
	public List<VerificationToken> findAllByExpiryDateLessThan(Date date) {
		return verificationTokenRepository.findAllByExpiryDateLessThan(date);
	}

}
