package com.example.nba.dao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "player_and_team")
@IdClass(PlayerAndChatPK.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerAndChat {
    @Id
    Long playerId;

    @Id
    Long teamId;
}
