package com.afterlie.footballtracker.service.impl;

import com.afterlie.footballtracker.dao.FootballFanRepository;
import com.afterlie.footballtracker.dto.FootballFanDto;
import com.afterlie.footballtracker.dto.FootballFanRegistrationDto;
import com.afterlie.footballtracker.exceptions.FootballFanException;
import com.afterlie.footballtracker.model.FootballFan;
import com.afterlie.footballtracker.model.FootballMatch;
import com.afterlie.footballtracker.model.Team;
import com.afterlie.footballtracker.service.FootballFanService;
import com.afterlie.footballtracker.util.mapper.FootballFanMapper;
import com.afterlie.footballtracker.util.mapper.FootballMatchMapper;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FootballFanServiceImplTest {
    private static final String FOOTBALL_FAN_NAME = "FootballFanName";
    private static final String FAKE_FOOTBALL_FAN_NAME = "FAKE Football fan name";
    public static final String FIRST_TEAM_NAME = "Team 1";
    public static final String SECOND_TEAM_NAME = "Team 2";
    public static final String CORRECT_PASSWORD = "123";
    public static final String NEW_CORRECT_PASSWORD = "123qwe";
    private static final Long FIRST_ID = 1L;
    private static final Long SECOND_ID = 2L;
    public static final LocalDate DAY_OF_1ST_MATCH = LocalDate.of(2020, 01, 01);
    public static final LocalDate DAY_OF_2ND_MATCH = LocalDate.of(2021, 03, 03);

    private Team team1;
    private Team team2;

    private FootballMatch footballMatch1;
    private FootballMatch footballMatch2;

    private Set<FootballMatch> footballMatches;

    private FootballFan footballFanWithId;
    private FootballFan footballFanWithIdUpdated;
    private FootballFan footballFanWithoutId;
    private FootballFan fakeFootballFan;

    List<FootballFan> footballFanList;

    private FootballFanRegistrationDto footballFanRegistrationDto;
    private FootballFanRegistrationDto fakeFootballFanRegistrationDto;

    private FootballFanDto footballFanDtoRegistered;
    private FootballFanDto footballFanDtoUpdated;

    private FootballFanRepository footballFanRepository;
    private FootballFanService footballFanService;

    @BeforeEach
    void setUp() {
        footballFanRepository = Mockito.mock(FootballFanRepository.class);
        footballFanService = new FootballFanServiceImpl(footballFanRepository);

        team1 = new Team();
        team1.setId(FIRST_ID);
        team1.setName(FIRST_TEAM_NAME);

        team2 = new Team();
        team2.setId(SECOND_ID);
        team2.setName(SECOND_TEAM_NAME);

        footballMatch1 = new FootballMatch();
        footballMatch1.setId(FIRST_ID);
        footballMatch1.setDateOfMatch(DAY_OF_1ST_MATCH);
        footballMatch1.setFirstTeam(team1);
        footballMatch1.setSecondTeam(team2);

        footballMatch2 = new FootballMatch();
        footballMatch2.setId(SECOND_ID);
        footballMatch2.setDateOfMatch(DAY_OF_2ND_MATCH);
        footballMatch2.setFirstTeam(team2);
        footballMatch2.setSecondTeam(team1);

        footballMatches = new HashSet<>();
        footballMatches.add(footballMatch1);
        footballMatches.add(footballMatch2);

        footballFanWithId = new FootballFan();
        footballFanWithId.setId(FIRST_ID);
        footballFanWithId.setName(FOOTBALL_FAN_NAME);
        footballFanWithId.setPassword(CORRECT_PASSWORD);

        footballFanWithoutId = new FootballFan();
        footballFanWithoutId.setName(FOOTBALL_FAN_NAME);
        footballFanWithoutId.setPassword(CORRECT_PASSWORD);

        footballFanWithIdUpdated = new FootballFan();
        footballFanWithIdUpdated.setId(FIRST_ID);
        footballFanWithIdUpdated.setName(FOOTBALL_FAN_NAME);
        footballFanWithIdUpdated.setPassword(NEW_CORRECT_PASSWORD);
        footballFanWithIdUpdated.setFootballMatches(footballMatches);

        fakeFootballFan = new FootballFan();
        fakeFootballFan.setId(FIRST_ID);
        fakeFootballFan.setName(FAKE_FOOTBALL_FAN_NAME);
        fakeFootballFan.setPassword(NEW_CORRECT_PASSWORD);
        fakeFootballFan.setFootballMatches(footballMatches);

        footballFanList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            FootballFan fan = new FootballFan();
            fan.setId(Long.valueOf(i));
            fan.setName("Fan #"+i);
            fan.setPassword(i + " " + i);
            footballFanList.add(fan);
        }

        footballFanRegistrationDto = new FootballFanRegistrationDto();
        footballFanRegistrationDto.setName(FOOTBALL_FAN_NAME);
        footballFanRegistrationDto.setPassword(CORRECT_PASSWORD);
        footballFanRegistrationDto.setRepeatPassword(CORRECT_PASSWORD);

        fakeFootballFanRegistrationDto = new FootballFanRegistrationDto();
        fakeFootballFanRegistrationDto.setName(FAKE_FOOTBALL_FAN_NAME);
        fakeFootballFanRegistrationDto.setPassword(CORRECT_PASSWORD);
        fakeFootballFanRegistrationDto.setRepeatPassword(CORRECT_PASSWORD);

        footballFanDtoRegistered = new FootballFanDto();
        footballFanDtoRegistered.setName(FOOTBALL_FAN_NAME);

        footballFanDtoUpdated = new FootballFanDto();
        footballFanDtoUpdated.setName(FOOTBALL_FAN_NAME);
        footballFanDtoUpdated.setMatches(footballMatches.stream()
                .map(fm -> Mappers.getMapper(FootballMatchMapper.class)
                        .fromFootballMatchToFootballMatchDto(fm))
                .collect(Collectors.toSet()));
    }

    @Test
    void create() {
        when(footballFanRepository.existsByName(FOOTBALL_FAN_NAME)).thenReturn(false);
        when(footballFanRepository.save(footballFanWithoutId)).thenReturn(footballFanWithId);
        assertEquals(footballFanDtoRegistered, footballFanService.create(footballFanRegistrationDto));

        when(footballFanRepository.existsByName(FAKE_FOOTBALL_FAN_NAME)).thenReturn(true);
        assertThrows(FootballFanException.class, () -> footballFanService.create(fakeFootballFanRegistrationDto));
    }

    @Test
    void update() {
        when(footballFanRepository.existsByName(FOOTBALL_FAN_NAME)).thenReturn(true);
        when(footballFanRepository.save(footballFanWithIdUpdated)).thenReturn(footballFanWithIdUpdated);
        assertEquals(footballFanDtoUpdated, footballFanService.update(footballFanWithIdUpdated));

        when(footballFanRepository.existsByName(FAKE_FOOTBALL_FAN_NAME)).thenReturn(false);
        assertThrows(FootballFanException.class, () -> footballFanService.update(fakeFootballFan));
    }

    @Test
    void getFootballFanById() {
        when(footballFanRepository.findById(FIRST_ID)).thenReturn(Optional.of(footballFanWithIdUpdated));
        assertEquals(footballFanDtoUpdated, footballFanService.getFootballFanById(FIRST_ID));

        when(footballFanRepository.findById(SECOND_ID)).thenReturn(Optional.empty());
        assertThrows(FootballFanException.class, ()-> footballFanService.getFootballFanById(SECOND_ID));
    }

    @Test
    void getFootballFanByName() {
        when(footballFanRepository.findByName(FOOTBALL_FAN_NAME)).thenReturn(Optional.of(footballFanWithIdUpdated));
        assertEquals(footballFanDtoUpdated, footballFanService.getFootballFanByName(FOOTBALL_FAN_NAME));

        when(footballFanRepository.findByName(FAKE_FOOTBALL_FAN_NAME)).thenReturn(Optional.empty());
        assertThrows(FootballFanException.class, ()-> footballFanService.getFootballFanByName(FAKE_FOOTBALL_FAN_NAME));
    }

    @Test
    void getAllFootballFans() {
        when(footballFanRepository.findAll()).thenReturn(footballFanList);
        assertEquals(footballFanList.stream()
                .map(ff -> Mappers.getMapper(FootballFanMapper.class)
                        .fromFootballFanToFootballFanDto(ff))
                .collect(Collectors.toList()), footballFanService.getAllFootballFans());
    }

    @Test
    void deleteFootballFanById() {
    }
}