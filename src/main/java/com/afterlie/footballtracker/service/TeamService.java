package com.afterlie.footballtracker.service;

import com.afterlie.footballtracker.dto.TeamDto;
import java.util.List;

public interface TeamService {
    TeamDto create(String teamName);

    TeamDto getTeamById(Long id);

    TeamDto getTeamByName(String name);

    List<TeamDto> getAllTeams();

    List<TeamDto> getAllTeamsByCountry(String country);

    TeamDto update(TeamDto teamDto);

    boolean deleteTeamById(Long id);

    boolean deleteTeamByName(String name);
}
