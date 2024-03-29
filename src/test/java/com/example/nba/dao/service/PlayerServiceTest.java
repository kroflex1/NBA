package com.example.nba.dao.service;

import com.example.nba.dao.IntegrationTest;
import com.example.nba.dao.entity.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PlayerServiceTest extends IntegrationTest {
    @Autowired
    PlayerService playerService;

    @Test
    @Rollback
    public void testAddNewPlayer() {
        Player expected = new Player("Vova", "Volkov", 1950, 1960);
        playerService.save(expected);

        List<Player> allPlayers = playerService.getAll();

        assertEquals(1, allPlayers.size());
        assertEquals(expected, allPlayers.get(0));
    }

    @Test
    @Rollback
    public void testIncorrectDateOrder() {
        Player expected = new Player("Vova", "Volkov", 1990, 1950);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                playerService.save(expected));
        assertEquals("End date of career cannot be earlier than start date of career", exception.getMessage());
    }

    @Test
    @Rollback
    public void testTooLongCareer() {
        Player expected = new Player("Vova", "Volkov", 1800, 1950);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                playerService.save(expected));
        assertEquals("Duration of career can`t be more than 100 years", exception.getMessage());
    }
}
