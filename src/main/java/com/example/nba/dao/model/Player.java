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
    long id;

    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surname;
    @Column(name = "from_year")
    int fromYear;
    @Column(name = "to_year")
    int toYear;

    public Player(String name, String surname, int fromYear, int toYear) {
        this.name = name;
        this.surname = surname;
        this.fromYear = fromYear;
        this.toYear = toYear;
    }
}
