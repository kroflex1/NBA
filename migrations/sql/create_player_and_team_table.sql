--liquibase formatted sql
--changeset Artyom:3

CREATE TABLE player_and_team
(
    player_id BIGINT NOT NULL,
    team_id   BIGINT NOT NULL,

    PRIMARY KEY (player_id, team_id),
    FOREIGN KEY (player_id) REFERENCES players (id) ON DELETE CASCADE,
    FOREIGN KEY (team_id) REFERENCES teams (id) ON DELETE CASCADE
)
