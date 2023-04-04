package maven.personnelSystem.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import maven.personnelSystem.validation.PasswordMatches;
import maven.personnelSystem.validation.ValidEmail;
import maven.personnelSystem.validation.ValidPassword;

@PasswordMatches
public class UserDto {

	@NotNull
	@Size(min = 3, max = 12, message = "İsim en az 3 en fazla 12 karakter olabilir.")
	private String firstName;

	private String lastName;

	@ValidEmail
	private String email;

	@ValidPassword
	private String password;

	private String matchingPassword;

	private String username;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
