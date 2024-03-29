package com.example.nba.dao.entity;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
@Data
@NoArgsConstructor
public class Team {
    @Id
    Long id;

    @Column(name = "name")
    String name;
    @Column(name = "city")
    String city;

    @OneToMany(mappedBy = "team")
    List<Player> playersInTeam = new ArrayList<>();

    public Team(Long id, @Nullable String name, @Nullable String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Team addPlayer(Player player) {
        playersInTeam.add(player);
        return this;
    }
}
