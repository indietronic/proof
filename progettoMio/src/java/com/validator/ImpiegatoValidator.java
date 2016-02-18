package java.com.validator;

import java.com.entities.ImpiegatoEntity;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ImpiegatoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ImpiegatoEntity.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstname", "FirstName is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastname", "LastName is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required");
	}

}
