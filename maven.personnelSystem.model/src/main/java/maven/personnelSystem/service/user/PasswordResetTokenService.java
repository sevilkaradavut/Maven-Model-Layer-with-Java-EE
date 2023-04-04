package maven.personnelSystem.service.user;

import java.util.Date;
import java.util.List;

import maven.personnelSystem.model.user.PasswordResetToken;
import maven.personnelSystem.model.user.User;

public interface PasswordResetTokenService {

	PasswordResetToken savePasswordResetToken(PasswordResetToken passwordResetToken);

	PasswordResetToken updatePasswordResetToken(PasswordResetToken passwordResetToken);

	PasswordResetToken deletePasswordResetToken(PasswordResetToken passwordResetToken);

	PasswordResetToken findPasswordResetTokenByToken(String token);

	PasswordResetToken findPasswordResetTokenByUser(User user);

	PasswordResetToken findPasswordResetTokenById(Long id);

	List<PasswordResetToken> findAllByExpiryDateLessThan(Date date);

}
