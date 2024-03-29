package com.example.nba.dao.service;

import com.example.nba.dao.entity.Player;
import com.example.nba.dao.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player save(Player player) throws IllegalArgumentException {
        checkCareerDates(player.getFromYear(), player.getToYear());
        return playerRepository.save(player);
    }

    public List<Player> getAll() {
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach(players::add);
        return players;
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
