package com.afterlie.footballtracker.dao;

import com.afterlie.footballtracker.model.FootballFan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FootballFanRepository extends JpaRepository<Long, FootballFan> {
}
