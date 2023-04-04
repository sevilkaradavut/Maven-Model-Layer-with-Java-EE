package maven.personnelSystem.web.dto;

import maven.personnelSystem.validation.PasswordMatches;
import maven.personnelSystem.validation.ValidPassword;

@PasswordMatches
public class PasswordDto {

	private String oldPassword;

	@ValidPassword
	private String newPassword;

	private String matchingNewPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getMatchingNewPassword() {
		return matchingNewPassword;
	}

	public void setMatchingNewPassword(String matchingNewPassword) {
		this.matchingNewPassword = matchingNewPassword;
	}

}
