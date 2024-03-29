package com.example.nba.dao.repository;

import com.example.nba.dao.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    @Query(value = "SELECT * FROM players ORDER BY (to_year - from_year) DESC LIMIT :top", nativeQuery = true)
    List<Player> findTopPlayersByCareerDuration(@Param("top") int top);

}
