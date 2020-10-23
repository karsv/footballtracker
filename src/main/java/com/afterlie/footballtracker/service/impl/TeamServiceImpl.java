package com.afterlie.footballtracker.service.impl;

import com.afterlie.footballtracker.dao.TeamRepository;
import com.afterlie.footballtracker.dto.TeamDto;
import com.afterlie.footballtracker.exceptions.TeamException;
import com.afterlie.footballtracker.model.Team;
import com.afterlie.footballtracker.service.TeamService;
import com.afterlie.footballtracker.util.mapper.TeamMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private TeamMapper teamMapper;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
        teamMapper = Mappers.getMapper(TeamMapper.class);
    }

    @Override
    public TeamDto create(TeamDto team) {
        if (teamRepository.existsByName(team.getTeamName())) {
            throw new TeamException("There is team with such name!");
        }
        return teamMapper
                .fromTeamToTeamDto(teamRepository
                        .save(teamMapper
                                .fromTeamDtoToTeam(team)));
    }

    @Override
    public TeamDto getTeamById(Long id) {
        return teamMapper
                .fromTeamToTeamDto(teamRepository
                        .findById(id)
                        .orElseThrow(() -> new TeamException("No team with such id!")));
    }

    @Override
    public TeamDto getTeamByName(String name) {
        return teamMapper
                .fromTeamToTeamDto(teamRepository
                        .findByName(name)
                        .orElseThrow(() -> new TeamException("No team with such name!")));
    }

    @Override
    public List<TeamDto> getAllTeams() {
        return teamRepository.findAll().stream()
                .map(team -> teamMapper.fromTeamToTeamDto(team))
                .collect(Collectors.toList());
    }

    @Override
    public List<TeamDto> getAllTeamsByCountry(String country) {
        return teamRepository.findAllByCountry(country).stream()
                .map(team -> teamMapper.fromTeamToTeamDto(team))
                .collect(Collectors.toList());
    }

    @Override
    public TeamDto update(Team team) {
        if(!teamRepository.existsById(team.getId())){
            throw new TeamException("There is no team with such id!");
        }
        return teamMapper.fromTeamToTeamDto(teamRepository.save(team));
    }

    @Override
    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public void deleteTeamByName(String name) {
        teamRepository.deleteByName(name);
    }
}
