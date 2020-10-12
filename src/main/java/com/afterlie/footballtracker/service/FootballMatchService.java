package com.afterlie.footballtracker.service;

import com.afterlie.footballtracker.dto.FootballMatchDto;
import java.time.LocalDate;
import java.util.List;

public interface FootballMatchService {
    FootballMatchDto create(FootballMatchDto footballMatchDto);

    FootballMatchDto update(FootballMatchDto footballMatchDto);

    FootballMatchDto getById(Long id);

    List<FootballMatchDto> getByTeam(String teamName);

    List<FootballMatchDto> getOnCurrentDate(LocalDate date);

    boolean deleteById(Long id);
}
