package com.afterlie.footballtracker.dao;

import com.afterlie.footballtracker.model.FootballFan;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FootballFanRepository extends JpaRepository<FootballFan, Long> {
    Optional<FootballFan> findByName(String name);

    boolean existsByName(String name);
}
