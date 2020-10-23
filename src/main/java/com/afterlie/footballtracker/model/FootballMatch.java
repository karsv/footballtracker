package com.afterlie.footballtracker.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class FootballMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Team firstTeam;
    @ManyToOne
    private Team secondTeam;
    private LocalDate dateOfMatch;

    public FootballMatch() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }

    public LocalDate getDateOfMatch() {
        return dateOfMatch;
    }

    public void setDateOfMatch(LocalDate dateOfMatch) {
        this.dateOfMatch = dateOfMatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballMatch that = (FootballMatch) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstTeam, that.firstTeam) &&
                Objects.equals(secondTeam, that.secondTeam) &&
                Objects.equals(dateOfMatch, that.dateOfMatch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstTeam, secondTeam, dateOfMatch);
    }
}
