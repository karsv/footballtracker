package com.afterlie.footballtracker.util.mapper;

import com.afterlie.footballtracker.dto.FootballFanDto;
import com.afterlie.footballtracker.dto.FootballFanRegistrationDto;
import com.afterlie.footballtracker.dto.FootballMatchDto;
import com.afterlie.footballtracker.model.FootballFan;
import com.afterlie.footballtracker.model.FootballMatch;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FootballFanMapper {
    FootballFan fromRegFootballFanDtoToFootballFan(
            FootballFanRegistrationDto footballFanRegistrationDto);

    @Mapping(source = "footballMatches", target = "matches", qualifiedByName = "setFootballMatchToSetFootballMatchDto")
    FootballFanDto fromFootballFanToFootballFanDto(FootballFan footballFan);

    public static Set<FootballMatchDto> setFootballMatchToSetFootballMatchDto(Set<FootballMatch> matches){
        return matches.stream()
                .map(fm -> Mappers.getMapper(FootballMatchMapper.class)
                        .fromFootballMatchToFootballMatchDto(fm))
                .collect(Collectors.toSet());
    }
}
