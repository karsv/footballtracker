package com.afterlie.footballtracker.dto;

import java.util.List;
import java.util.Objects;

public class TeamDto {
    private String name;
    private String country;
    private List<FootballMatchDto> matches;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FootballMatchDto> getMatches() {
        return matches;
    }

    public void setMatches(List<FootballMatchDto> matches) {
        this.matches = matches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamDto teamDto = (TeamDto) o;
        return Objects.equals(name, teamDto.name) &&
                Objects.equals(country, teamDto.country) &&
                Objects.equals(matches, teamDto.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, matches);
    }
}
