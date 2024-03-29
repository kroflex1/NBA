package com.example.nba.dao.entity;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "from_year", nullable = false)
    Integer fromYear;

    @Column(name = "to_year", nullable = false)
    Integer toYear;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    @EqualsAndHashCode.Exclude
    Team team;

    public Player(String name, @Nullable String surname, int fromYear, int toYear) throws IllegalArgumentException {
        checkCareerDates(fromYear, toYear);
        this.name = name;
        this.surname = surname;
        this.fromYear = fromYear;
        this.toYear = toYear;
    }

    private void checkCareerDates(int fromYear, int toYear) throws IllegalArgumentException {
        if (fromYear > toYear) {
            throw new IllegalArgumentException("End date of career cannot be earlier than start date of career");
        }
        if (toYear - fromYear > 100) {
            throw new IllegalArgumentException("Duration of career can`t be more than 100 years");
        }
    }
}
