--liquibase formatted sql
--changeset Artyom:2

CREATE TABLE players
(
    id        BIGSERIAL   NOT NULL,
    name      VARCHAR(50) NOT NULL,
    surname   VARCHAR(50) NOT NULL,
    from_year INT         NOT NULL,
    to_year   INT         NOT NULL,
    team_id   BIGINT      NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (team_id) REFERENCES teams (id)
)
