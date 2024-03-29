package com.example.nba.dao.service;

import com.example.nba.dao.entity.Player;
import com.example.nba.dao.entity.Team;
import com.example.nba.dao.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }


    public List<Team> getAll() {
        List<Team> teams = new ArrayList<>();
        teamRepository.findAll().forEach(teams::add);
        return teams;
    }

    @Transactional
    public Team addPlayerToTeam(Long teamId, Player player) throws NoSuchElementException {
        Team team = teamRepository.findById(teamId).orElseThrow();
        team.addPlayer(player);
        return teamRepository.save(team);
    }

    @Transactional
    public List<Player> getPlayersFromTeam(Long teamId) throws NoSuchElementException {
        Team team = teamRepository.findById(teamId).orElseThrow();
        return team.getPlayersInTeam();
    }
}
