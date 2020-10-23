package com.afterlie.footballtracker.passwordEqualValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomPasswordEqualValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordEqualValidator {
    String message() default "Passwords aren't equal!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
