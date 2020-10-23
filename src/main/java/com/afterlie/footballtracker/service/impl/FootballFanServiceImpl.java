package com.afterlie.footballtracker.service.impl;

import com.afterlie.footballtracker.dao.FootballFanRepository;
import com.afterlie.footballtracker.dto.FootballFanDto;
import com.afterlie.footballtracker.dto.FootballFanRegistrationDto;
import com.afterlie.footballtracker.exceptions.FootballFanException;
import com.afterlie.footballtracker.model.FootballFan;
import com.afterlie.footballtracker.service.FootballFanService;
import com.afterlie.footballtracker.util.mapper.FootballFanMapper;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FootballFanServiceImpl implements FootballFanService {
    private final FootballFanRepository footballFanRepository;
    private FootballFanMapper footballFanMapper;

    public FootballFanServiceImpl(FootballFanRepository footballFanRepository) {
        this.footballFanRepository = footballFanRepository;
        footballFanMapper = Mappers.getMapper(FootballFanMapper.class);
    }

    @Override
    @Transactional
    public FootballFanDto create(FootballFanRegistrationDto footballFanRegistrationDto) {
        if (footballFanRepository.existsByName(footballFanRegistrationDto.getName())) {
            throw new FootballFanException("There is football fan with such name!");
        }
        return footballFanMapper
                .fromFootballFanToFootballFanDto(
                        footballFanRepository.save(footballFanMapper
                                .fromRegFootballFanDtoToFootballFan(footballFanRegistrationDto)));
    }

    @Override
    @Transactional
    public FootballFanDto update(FootballFan footballFan) {
        if(!footballFanRepository.existsByName(footballFan.getName())){
            throw new FootballFanException("There isn't football fan with such name!");
        }
        return footballFanMapper
                .fromFootballFanToFootballFanDto(footballFanRepository.save(footballFan));
    }

    @Override
    public FootballFanDto getFootballFanById(Long id) {
        return footballFanMapper
                .fromFootballFanToFootballFanDto(footballFanRepository
                        .findById(id)
                        .orElseThrow(() -> new FootballFanException("No football fan with such id!")));
    }

    @Override
    public FootballFanDto getFootballFanByName(String name) {
        return footballFanMapper
                .fromFootballFanToFootballFanDto(footballFanRepository
                        .findByName(name)
                        .orElseThrow(() -> new FootballFanException("No football fan with such name!")));
    }

    @Override
    public List<FootballFanDto> getAllFootballFans() {
        return footballFanRepository.findAll()
                .stream().map(ff -> footballFanMapper
                        .fromFootballFanToFootballFanDto(ff))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFootballFanById(Long id) {
        footballFanRepository.deleteById(id);
    }
}
