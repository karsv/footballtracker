package com.afterlie.footballtracker.dto;

import com.afterlie.footballtracker.passwordEqualValidator.PasswordEqualValidator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordEqualValidator
public class FootballFanRegistrationDto {
    @NotNull(message = "Football fan must have name!")
    @Size(min = 3, message = "Football fans name must get more then 3 symbols!")
    private String name;
    @NotNull(message = "FF must have password!")
    @Size(min = 3, message = "password must be more then 3 symbols!")
    private String password;
    @NotNull(message = "you must repeat password!")
    @Size(min = 3, message = "Repeated password must be the same then password!")
    private String repeatPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
