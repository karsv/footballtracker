package com.afterlie.footballtracker.dao;

import com.afterlie.footballtracker.model.FootballMatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FootballMatchRepository extends JpaRepository<Long, FootballMatch> {
}
