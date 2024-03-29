package com.example.nba.dao.service;

import com.example.nba.dao.model.Player;
import com.example.nba.dao.model.Team;
import com.example.nba.dao.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Team addPlayerToTeam(Long teamId, Player player) throws IllegalArgumentException {
        Team team = getTeamById(teamId);
        team.addPlayer(player);
        return teamRepository.save(team);
    }

    public List<Player> getPlayersFromTeam(Long teamId) {
        Team team = getTeamById(teamId);
        return team.getPlayersInTeam();
    }

    private Team getTeamById(Long teamId) throws IllegalArgumentException {
        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isEmpty()) {
            throw new IllegalArgumentException("command with id=%d wasn`t found".formatted(teamId));
        }
        return teamRepository.save(team.get());
    }
}
