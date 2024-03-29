package com.example.nba.dao.dto;

import com.example.nba.dao.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerDTO {
    String name;
    String surname;
    int fromYear;
    int toYear;
    long teamId;

    public static PlayerDTO convertEntityToDTO(Player player) {
        return new PlayerDTO(player.getName(), player.getSurname(), player.getFromYear(), player.getToYear(), player.getTeam().getId());
    }
}
