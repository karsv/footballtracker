package com.afterlie.footballtracker.util.mapper;

import com.afterlie.footballtracker.dto.FootballFanDto;
import com.afterlie.footballtracker.dto.FootballFanRegistrationDto;
import com.afterlie.footballtracker.model.FootballFan;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FootballFanMapper {
    FootballFan fromRegFootballFanDtoToFootballFan(
            FootballFanRegistrationDto footballFanRegistrationDto);

    FootballFanDto fromFootballFanToFootballFanDto(FootballFan footballFan);
}
