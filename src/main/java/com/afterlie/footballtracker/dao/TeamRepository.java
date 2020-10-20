package com.afterlie.footballtracker.dao;

import com.afterlie.footballtracker.model.Team;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    boolean existsByName(String name);

    Optional<Team> findByName(String name);

    List<Team> findAllByCountry(String country);

    void deleteByName(String name);
}
