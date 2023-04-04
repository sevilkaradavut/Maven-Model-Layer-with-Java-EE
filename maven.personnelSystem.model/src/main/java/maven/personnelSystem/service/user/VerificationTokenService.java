package maven.personnelSystem.service.user;

import java.util.Date;
import java.util.List;

import maven.personnelSystem.model.user.User;
import maven.personnelSystem.model.user.VerificationToken;

public interface VerificationTokenService {

	VerificationToken saveVerificationToken(VerificationToken verificationToken);

	VerificationToken updateVerificationToken(VerificationToken verificationToken);

	VerificationToken deleteVerificationToken(VerificationToken verificationToken);

	VerificationToken findVerificationTokenByToken(String token);

	VerificationToken findVerificationTokenByUser(User user);

	VerificationToken findVerificationTokenById(Long id);

	List<VerificationToken> findAllByExpiryDateLessThan(Date date);
}
