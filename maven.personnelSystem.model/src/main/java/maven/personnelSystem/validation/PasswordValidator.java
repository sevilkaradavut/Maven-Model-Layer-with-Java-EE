package maven.personnelSystem.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.DigitCharacterRule;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.SpecialCharacterRule;
import org.passay.UppercaseCharacterRule;
import org.passay.WhitespaceRule;

import com.google.common.base.Joiner;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

	@Override
	public void initialize(ValidPassword constraintAnnotation) {

	}

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		List<Rule> rules = new ArrayList<>();
		rules.add(new LengthRule(5, 30));
		rules.add(new UppercaseCharacterRule());
		rules.add(new WhitespaceRule());
		rules.add(new DigitCharacterRule(1));
		rules.add(new SpecialCharacterRule(1));

		org.passay.PasswordValidator validator = new org.passay.PasswordValidator(rules);
		RuleResult result = validator.validate(new PasswordData(password));

		if (result.isValid()) {
			return true;
		}
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(Joiner.on("\n").join(validator.getMessages(result)))
				.addConstraintViolation();

		return false;
	}

}
