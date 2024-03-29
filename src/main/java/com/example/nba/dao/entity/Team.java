package com.example.nba.dao.entity;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    List<Player> playersInTeam = new ArrayList<>();

    public Team(Long id, @Nullable String name, @Nullable String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public void addPlayer(Player player) {
        player.setTeam(this);
        playersInTeam.add(player);
    }
}
