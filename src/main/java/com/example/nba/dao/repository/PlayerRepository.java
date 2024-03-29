package com.example.nba.dao.repository;

import com.example.nba.dao.entity.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
