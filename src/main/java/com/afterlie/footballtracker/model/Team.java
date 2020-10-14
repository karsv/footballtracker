package com.afterlie.footballtracker.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String country;
    @ManyToMany
    private List<FootballMatch> matches;

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) &&
                Objects.equals(name, team.name) &&
                Objects.equals(country, team.country) &&
                Objects.equals(matches, team.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, matches);
    }
}
