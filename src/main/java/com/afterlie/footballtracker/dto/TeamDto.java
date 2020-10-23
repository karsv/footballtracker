package com.afterlie.footballtracker.dto;

import java.util.Objects;

public class TeamDto {
    private Long id;
    private String teamName;
    private String country;

    public TeamDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamDto teamDto = (TeamDto) o;
        return Objects.equals(id, teamDto.id) &&
                Objects.equals(teamName, teamDto.teamName) &&
                Objects.equals(country, teamDto.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamName, country);
    }
}
