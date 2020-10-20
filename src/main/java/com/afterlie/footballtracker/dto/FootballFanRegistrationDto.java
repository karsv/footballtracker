package com.afterlie.footballtracker.dto;

import com.afterlie.footballtracker.passwordEqualValidator.PasswordEqualValidator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballFanRegistrationDto that = (FootballFanRegistrationDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(password, that.password) &&
                Objects.equals(repeatPassword, that.repeatPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, repeatPassword);
    }
}
