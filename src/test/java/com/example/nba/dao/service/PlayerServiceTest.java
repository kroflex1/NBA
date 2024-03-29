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



}
