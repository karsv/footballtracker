package com.afterlie.footballtracker.dto;

import java.util.List;

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
}
