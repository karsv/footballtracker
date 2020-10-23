package com.afterlie.footballtracker.dto;

import java.util.Objects;

public class FootballMatchDto {
    private String team1;
    private String team2;
    private String dateOfMatch;

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getDateOfMatch() {
        return dateOfMatch;
    }

    public void setDateOfMatch(String dateOfMatch) {
        this.dateOfMatch = dateOfMatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballMatchDto that = (FootballMatchDto) o;
        return Objects.equals(team1, that.team1) &&
                Objects.equals(team2, that.team2) &&
                Objects.equals(dateOfMatch, that.dateOfMatch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team1, team2, dateOfMatch);
    }
}
