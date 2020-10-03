package com.afterlie.footballtracker.model;

import javax.persistence.*;
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

    public Set<FootballMatch> getFootballMatches() {
        return footballMatches;
    }

    public void setFootballMatches(Set<FootballMatch> footballMatches) {
        this.footballMatches = footballMatches;
    }
}
