package com.example.nba.dao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PlayerAndChatPK implements Serializable {
    @Column(name = "player_id", nullable = false)
    Long playerId;
    @Column(name = "team_id", nullable = false)
    Long teamId;

}
