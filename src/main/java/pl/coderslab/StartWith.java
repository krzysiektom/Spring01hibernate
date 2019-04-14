package pl.coderslab;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StartWithValidator.class) ////klasa validatora
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StartWith {
	String value(); //przekazywany jeden parametr
	String message() default "{startWith.validator.error.message}"; //kod błędu
	Class<?>[] groups() default {}; //nie wykorzystujemy
	Class<? extends Payload>[] payload() default {}; //nie wykorzystujemy
}