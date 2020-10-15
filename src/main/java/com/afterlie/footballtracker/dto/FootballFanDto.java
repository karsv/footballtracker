package com.afterlie.footballtracker.dto;

import com.afterlie.footballtracker.model.FootballMatch;
import java.util.List;

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
}
