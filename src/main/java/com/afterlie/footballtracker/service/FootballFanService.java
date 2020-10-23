package com.afterlie.footballtracker.service;

import com.afterlie.footballtracker.dto.FootballFanDto;
import com.afterlie.footballtracker.dto.FootballFanRegistrationDto;
import com.afterlie.footballtracker.model.FootballFan;
import java.util.List;

public interface FootballFanService {
    FootballFanDto create(FootballFanRegistrationDto footballFanRegistrationDto);

    FootballFanDto update(FootballFan footballFan);

    FootballFanDto getFootballFanById(Long id);

    FootballFanDto getFootballFanByName(String name);

    List<FootballFanDto> getAllFootballFans();

    void deleteFootballFanById(Long id);
}
