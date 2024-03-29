package com.example.nba.dao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "surname", nullable = false)
    String surname;
    @Column(name = "from_year", nullable = false)
    int fromYear;
    @Column(name = "to_year", nullable = false)
    int toYear;

    public Player(String name, String surname, int fromYear, int toYear) {
        this.name = name;
        this.surname = surname;
        this.fromYear = fromYear;
        this.toYear = toYear;
    }
}
