package com.afterlie.footballtracker.util.mapper;

import com.afterlie.footballtracker.dto.TeamDto;
import com.afterlie.footballtracker.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TeamMapper {
    @Mapping(source = "teamName", target = "name")
    Team fromTeamDtoToTeam(TeamDto teamDto);

    @Mapping(source = "name", target = "teamName")
    TeamDto fromTeamToTeamDto(Team team);
}
