package com.example.nba.dao.service;

import com.example.nba.dao.entity.Player;
import com.example.nba.dao.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @Transactional
    public List<Player> getAll() {
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach(players::add);
        return players;
    }

    @Transactional
    public List<Player> getTopPlayersByCareerDuration(int top) {
        return playerRepository.findTopPlayersByCareerDuration(top);
    }
}
