package com.example.nba.dao.service;

import com.example.nba.dao.IntegrationTest;
import com.example.nba.dao.entity.Player;
import com.example.nba.dao.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@Transactional
public class TeamServiceTest extends IntegrationTest {
    @Autowired
    TeamService teamService;
    @Autowired
    PlayerService playerService;

    @Test
    @Rollback
    public void testAddNewTeam() {
        Team expected = new Team(1L, "Lakers", "Los Angeles");
        teamService.save(expected);

        List<Team> teams = teamService.getAll();

        assertTrue(teams.size() == 1);
        assertEquals(expected, teams.get(0));
    }

    @Test
    @Rollback
    public void testAddAlreadyExistTeam() {
        Team team = new Team(1L, "Lakers", "Los Angeles");
        teamService.save(team);
        teamService.save(team);

        List<Team> actual = teamService.getAll();
        assertTrue(actual.size() == 1);
    }


    @Test
    @Rollback
    public void testAddPlayerToTeam() {
        Team team = new Team(1L, "Lakers", "Los Angeles");
        Player player = new Player("Dima", "Lebedev", 1950, 1960);
        playerService.save(player);
        teamService.save(team);
        teamService.addPlayerToTeam(team.getId(), player);

        Player actual = teamService.getPlayersFromTeam(team.getId()).get(0);

        assertEquals(player, actual);
    }


    @Test
    @Rollback
    public void testAddSeveralPlayers(){
        Set<Player> expected = List.of(
                new Player("Vova", "Borsukov", 1967, 1988),
                new Player())
    }
}
