package pl.coderslab;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValidator implements ConstraintValidator<StartWith, String> {
    private String toCheck;

    public void initialize(StartWith startWith) {
        this.toCheck = startWith.value();
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.startsWith(toCheck);
    }
}
