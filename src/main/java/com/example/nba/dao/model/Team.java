package com.example.nba.dao.model;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "name")
    String name;
    @Column(name = "city")
    String city;

    public Team(@Nullable String name, @Nullable String city) {
        this.name = name;
        this.city = city;
    }
}
