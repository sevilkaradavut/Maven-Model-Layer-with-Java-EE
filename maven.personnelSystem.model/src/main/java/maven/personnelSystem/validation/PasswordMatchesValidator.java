package maven.personnelSystem.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import maven.personnelSystem.web.dto.PasswordDto;
import maven.personnelSystem.web.dto.UserDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {

	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		if (obj.getClass().equals(UserDto.class)) {
			UserDto userDto = (UserDto) obj;
			return userDto.getPassword().equals(userDto.getMatchingPassword());
		} else {
			PasswordDto passwordDto = (PasswordDto) obj;
			return passwordDto.getNewPassword().equals(passwordDto.getMatchingNewPassword());
		}

	}

}
