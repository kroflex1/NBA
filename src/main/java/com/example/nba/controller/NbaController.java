package com.example.nba.controller;

import com.example.nba.dao.dto.PlayerDTO;
import com.example.nba.dao.entity.Team;
import com.example.nba.dao.service.PlayerService;
import com.example.nba.dao.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class NbaController {

    private final TeamService teamService;
    private final PlayerService playerService;

    public NbaController(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }


    @GetMapping("/teams/playersCount")
    @ResponseBody
    public Map<Long, Integer> getNumberOfPlayersInTeams() {
        Map<Long, Integer> result = new HashMap<>();
        for (Team team : teamService.getAll()) {
            result.put(team.getId(), team.getPlayersInTeam().size());
        }
        return result;
    }


    @GetMapping("/players")
    @ResponseBody
    public List<PlayerDTO> getTopPlayersByCareerDuration(@RequestParam int top) {
        return playerService.getTopPlayersByCareerDuration(20)
                .stream()
                .map(PlayerDTO::convertEntityToDTO)
                .collect(Collectors.toList());
    }


    @GetMapping("/teams/{teamId}/players")
    @ResponseBody
    public List<PlayerDTO> getPlayersAtTeam(@PathVariable Long teamId) {
        return teamService.getPlayersFromTeam(teamId)
                .stream()
                .map(PlayerDTO::convertEntityToDTO)
                .collect(Collectors.toList());
    }
}
