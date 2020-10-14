package com.afterlie.footballtracker.dto;

import com.afterlie.footballtracker.model.FootballMatch;
import java.util.List;
import java.util.Objects;

public class FootballFanDto {
    private String name;
    private List<FootballMatchDto> matches;

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
        FootballFanDto that = (FootballFanDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(matches, that.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, matches);
    }
}
