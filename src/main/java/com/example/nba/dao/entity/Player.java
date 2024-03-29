package com.example.nba.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "players")
@Data
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
    Integer fromYear;

    @Column(name = "to_year", nullable = false)
    Integer toYear;

    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;


    public Player(String name, String surname, int fromYear, int toYear) {
        this.name = name;
        this.surname = surname;
        this.fromYear = fromYear;
        this.toYear = toYear;
    }
}
