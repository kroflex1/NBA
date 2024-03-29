--liquibase formatted sql
--changeset Artyom:2

CREATE TABLE teams
(
    id   BIGINT       NOT NULL,
    name VARCHAR(150) NULL,
    city VARCHAR(150) NULL,
    PRIMARY KEY (id)
)
