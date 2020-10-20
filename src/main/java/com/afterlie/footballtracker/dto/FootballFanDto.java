package com.afterlie.footballtracker.dto;

import java.util.Objects;
import java.util.Set;

public class FootballFanDto {
    private String name;
    private Set<FootballMatchDto> matches;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<FootballMatchDto> getMatches() {
        return matches;
    }

    public void setMatches(Set<FootballMatchDto> matches) {
        this.matches = matches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballFanDto that = (FootballFanDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(matches, that.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, matches);
    }
}
