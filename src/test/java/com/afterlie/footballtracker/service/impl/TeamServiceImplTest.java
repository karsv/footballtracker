package com.afterlie.footballtracker.service.impl;

import com.afterlie.footballtracker.dao.TeamRepository;
import com.afterlie.footballtracker.dto.TeamDto;
import com.afterlie.footballtracker.exceptions.TeamException;
import com.afterlie.footballtracker.model.Team;
import com.afterlie.footballtracker.service.TeamService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class TeamServiceImplTest {
    public static final String EXISTED_TEAM_NAME = "Existed team";
    public static final String NOT_EXISTED_TEAM_NAME = "Not existed team";
    public static final String TEAM_NAME = "New team";
    public static final String COUNTRY = "Country";
    private static final Long NEW_ID = 1L;
    private static final Long NOT_EXISTED_ID = 2L;

    private TeamService teamService;
    private TeamRepository teamRepository;
    private TeamDto teamDtoRegistered;
    private Team newTeamWithoutId;
    private Team newTeamWithId;
    private TeamDto newTeamDto;

    @BeforeEach
    void setUp() {
        teamRepository = Mockito.mock(TeamRepository.class);
        teamService = new TeamServiceImpl(teamRepository);

        newTeamWithId = new Team();
        newTeamWithId.setId(NEW_ID);
        newTeamWithId.setName(TEAM_NAME);
        newTeamWithId.setCountry(COUNTRY);

        newTeamDto = new TeamDto();
        newTeamDto.setId(NEW_ID);
        newTeamDto.setTeamName(TEAM_NAME);
        newTeamDto.setCountry(COUNTRY);
    }

    @Test
    void create() {
        teamDtoRegistered = new TeamDto();
        teamDtoRegistered.setTeamName(EXISTED_TEAM_NAME);
        teamDtoRegistered.setCountry(COUNTRY);
        when(teamRepository.existsByName(EXISTED_TEAM_NAME)).thenReturn(true);
        assertThrows(TeamException.class, () -> teamService.create(teamDtoRegistered));

        newTeamWithoutId = new Team();
        newTeamWithoutId.setName(TEAM_NAME);
        newTeamWithoutId.setCountry(COUNTRY);

        teamDtoRegistered.setTeamName(TEAM_NAME);

        when(teamRepository.existsByName(TEAM_NAME)).thenReturn(false);
        when(teamRepository.save(newTeamWithoutId)).thenReturn(newTeamWithId);
        assertEquals(newTeamDto, teamService.create(teamDtoRegistered));
    }

    @Test
    void getTeamById() {
        when(teamRepository.findById(NEW_ID)).thenReturn(Optional.of(newTeamWithId));
        assertEquals(newTeamDto, teamService.getTeamById(NEW_ID));

        when(teamRepository.findById(NOT_EXISTED_ID)).thenReturn(Optional.empty());
        assertThrows(TeamException.class, () -> teamService.getTeamById(NOT_EXISTED_ID));
    }

    @Test
    void getTeamByName() {
        when(teamRepository.findByName(TEAM_NAME)).thenReturn(Optional.of(newTeamWithId));
        assertEquals(newTeamDto, teamService.getTeamByName(TEAM_NAME));

        when(teamRepository.findByName(NOT_EXISTED_TEAM_NAME)).thenReturn(Optional.empty());
        assertThrows(TeamException.class, () -> teamService.getTeamByName(NOT_EXISTED_TEAM_NAME));
    }

    @Test
    void getAllTeams() {
        List<Team> teamList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Team team = new Team();
            team.setId(Long.valueOf(i));
            team.setName("Team " + i);
            team.setCountry("Country " + i);
            teamList.add(team);
        }

        List<TeamDto> teamDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TeamDto team = new TeamDto();
            team.setId(Long.valueOf(i));
            team.setTeamName("Team " + i);
            team.setCountry("Country " + i);
            teamDtoList.add(team);
        }
        when(teamRepository.findAll()).thenReturn(teamList);
        assertEquals(teamDtoList, teamService.getAllTeams());
    }

    @Test
    void getAllTeamsByCountry() {
        List<Team> teamList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Team team = new Team();
            team.setId(Long.valueOf(i));
            team.setName("Team " + i);
            team.setCountry(COUNTRY);
            teamList.add(team);
        }

        List<TeamDto> teamDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TeamDto team = new TeamDto();
            team.setId(Long.valueOf(i));
            team.setTeamName("Team " + i);
            team.setCountry(COUNTRY);
            teamDtoList.add(team);
        }
        when(teamRepository.findAllByCountry(COUNTRY)).thenReturn(teamList);
        assertEquals(teamDtoList, teamService.getAllTeamsByCountry(COUNTRY));
    }

    @Test
    void update() {
        when(teamRepository.existsById(NEW_ID)).thenReturn(true);
        when(teamRepository.save(newTeamWithId)).thenReturn(newTeamWithId);
        assertEquals(newTeamDto, teamService.update(newTeamWithId));

        when(teamRepository.existsById(NOT_EXISTED_ID)).thenReturn(false);
        Team notExistedTeam = new Team();
        notExistedTeam.setName(NOT_EXISTED_TEAM_NAME);
        notExistedTeam.setCountry(COUNTRY);
        notExistedTeam.setId(NOT_EXISTED_ID);
        assertThrows(TeamException.class, ()->teamService.update(notExistedTeam));
    }
}