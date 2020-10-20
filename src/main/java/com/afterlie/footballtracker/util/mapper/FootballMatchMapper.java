package com.afterlie.footballtracker.util.mapper;

import com.afterlie.footballtracker.dto.FootballMatchDto;
import com.afterlie.footballtracker.model.FootballMatch;
import org.mapstruct.Mapper;

@Mapper
public interface FootballMatchMapper {
    FootballMatchDto fromFootballMatchToFootballMatchDto(FootballMatch footballMatch);
}
