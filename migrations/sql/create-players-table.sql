--liquibase formatted sql
--changeset Artyom:1

CREATE TABLE players
(
    id        SERIAL      NOT NULL,
    name      VARCHAR(50) NOT NULL,
    surname   VARCHAR(50) NOT NULL,
    from_year INT         NOT NULL,
    to_year   INT         NOT NULL,
    team_id   BIGINT      NOT NULL,
    PRIMARY KEY (id)
)
