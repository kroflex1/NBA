package com.example.nba.dao.repository;

import com.example.nba.dao.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
