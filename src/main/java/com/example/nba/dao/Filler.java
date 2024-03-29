package com.example.nba.dao;

import com.example.nba.dao.entity.Player;
import com.example.nba.dao.entity.Team;
import com.example.nba.dao.service.TeamService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class Filler  {
    private final static int PLAYER_NAME_INDEX = 2;
    private final static int FROM_YEAR_INDEX = 3;
    private final static int TO_YEAR_INDEX = 14;
    private final static int TEAM_NAME_INDEX = 13;
    private final static int TEAM_ID_INDEX = 12;
    private final static int TEAM_CITY_INDEX = 10;
    private final TeamService teamService;

    @Autowired
    public Filler(TeamService teamService) throws Exception {
        this.teamService = teamService;

    }


//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Path path = new File(".").getAbsoluteFile().toPath().getParent().resolve(Path.of("src", "main", "resources", "static", "NBA-playerlist.csv"));
//        fillTablesFromCsvFile(path);
//    }

    private void fillTablesFromCsvFile(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()) {
                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    Player player;
                    try {
                        player = createPlayerFromRecords(line);
                    } catch (IllegalArgumentException e) {
                        continue;
                    }

                    Team team = new Team(Long.parseLong(line[TEAM_ID_INDEX]), line[TEAM_NAME_INDEX], line[TEAM_CITY_INDEX]);
                    teamService.addTeam(team);
                    teamService.addPlayerToTeam(team.getId(), player);
                }
            }
        }
    }

    private Player createPlayerFromRecords(String[] records) throws IllegalArgumentException {
        String[] playerPartNames = records[PLAYER_NAME_INDEX].split(", ");
        String playerName;
        String playerSurname;
        if (playerPartNames.length == 2) {
            playerSurname = playerPartNames[0];
            playerName = playerPartNames[1];
        } else {
            playerSurname = null;
            playerName = playerPartNames[0];
        }
        Player player = new Player(
                playerName,
                playerSurname,
                Integer.parseInt(records[FROM_YEAR_INDEX]),
                Integer.parseInt(records[TO_YEAR_INDEX]));
        return player;
    }

}
