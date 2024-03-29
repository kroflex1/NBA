package com.example.nba.dao.repository;

import com.example.nba.dao.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
