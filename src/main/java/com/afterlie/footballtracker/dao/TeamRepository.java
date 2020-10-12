package com.afterlie.footballtracker.dao;

import com.afterlie.footballtracker.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Long, Team> {
}
