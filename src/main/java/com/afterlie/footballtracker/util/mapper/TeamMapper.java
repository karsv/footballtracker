package com.afterlie.footballtracker.util.mapper;

import com.afterlie.footballtracker.dto.TeamDto;
import com.afterlie.footballtracker.model.Team;
import org.mapstruct.Mapper;

@Mapper
public interface TeamMapper {
    Team fromTeamDtoToTeam(TeamDto teamDto);

    TeamDto fromTeamToTeamDto(Team team);
}
