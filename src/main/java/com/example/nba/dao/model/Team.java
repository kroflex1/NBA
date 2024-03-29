package com.example.nba.dao.model;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;
    @Column(name = "city")
    String city;

    @OneToMany
    @JoinColumn(name = "team_id")
    List<Player> playersInTeam;

    public Team(@Nullable String name, @Nullable String city) {
        this.name = name;
        this.city = city;
    }

    public Team addPlayer(Player player) {
        playersInTeam.add(player);
        return this;
    }
}
