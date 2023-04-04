package maven.personnelSystem.service.user.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maven.personnelSystem.dao.user.PasswordResetTokenRepository;
import maven.personnelSystem.model.user.PasswordResetToken;
import maven.personnelSystem.model.user.User;
import maven.personnelSystem.service.user.PasswordResetTokenService;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService{

	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;
	
	@Override
	public PasswordResetToken savePasswordResetToken(PasswordResetToken passwordResetToken) {
		return passwordResetTokenRepository.savePasswordResetToken(passwordResetToken);
	}

	@Override
	public PasswordResetToken updatePasswordResetToken(PasswordResetToken passwordResetToken) {
		return passwordResetTokenRepository.updatePasswordResetToken(passwordResetToken);
	}

	@Override
	public PasswordResetToken deletePasswordResetToken(PasswordResetToken passwordResetToken) {
		return passwordResetTokenRepository.deletePasswordResetToken(passwordResetToken);
	}

	@Override
	public PasswordResetToken findPasswordResetTokenByToken(String token) {
		return passwordResetTokenRepository.findPasswordResetTokenByToken(token);
	}

	@Override
	public PasswordResetToken findPasswordResetTokenByUser(User user) {
		return passwordResetTokenRepository.findPasswordResetTokenByUser(user);
	}

	@Override
	public PasswordResetToken findPasswordResetTokenById(Long id) {
		return passwordResetTokenRepository.findPasswordResetTokenById(id);
	}

	@Override
	public List<PasswordResetToken> findAllByExpiryDateLessThan(Date date) {
		return passwordResetTokenRepository.findAllByExpiryDateLessThan(date);
	}

}
