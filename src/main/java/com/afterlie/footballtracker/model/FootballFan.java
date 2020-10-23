package com.afterlie.footballtracker.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class FootballFan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;

    @OneToMany
    private Set<FootballMatch> footballMatches;

    public FootballFan() {
        footballMatches = new HashSet<>();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<FootballMatch> addFootballMatch(FootballMatch footballMatch){
        footballMatches.add(footballMatch);
        return footballMatches;
    }

    public Set<FootballMatch> getFootballMatches() {
        return footballMatches;
    }

    public void setFootballMatches(Set<FootballMatch> footballMatches) {
        this.footballMatches = footballMatches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballFan that = (FootballFan) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(password, that.password) &&
                Objects.equals(footballMatches, that.footballMatches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, footballMatches);
    }
}
