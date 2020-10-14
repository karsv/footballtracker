package com.afterlie.footballtracker.passwordEqualValidator;

import com.afterlie.footballtracker.dto.FootballFanRegistrationDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomPasswordEqualValidator implements
        ConstraintValidator<PasswordEqualValidator, FootballFanRegistrationDto> {
    @Override
    public boolean isValid(FootballFanRegistrationDto user,
                           ConstraintValidatorContext constraintValidatorContext) {
        return user.getPassword()
                .equals(user.getRepeatPassword());
    }
}
