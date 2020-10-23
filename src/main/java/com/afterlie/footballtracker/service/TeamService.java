package com.afterlie.footballtracker.service;

import com.afterlie.footballtracker.dto.TeamDto;
import com.afterlie.footballtracker.model.Team;
import java.util.List;

public interface TeamService {
    TeamDto create(TeamDto team);

    TeamDto getTeamById(Long id);

    TeamDto getTeamByName(String name);

    List<TeamDto> getAllTeams();

    List<TeamDto> getAllTeamsByCountry(String country);

    TeamDto update(Team team);

    void deleteTeamById(Long id);

    void deleteTeamByName(String name);
}
