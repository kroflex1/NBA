package com.example.nba.dao.entity;

import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    @Test
    @Rollback
    public void testIncorrectDateOrder() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Player("Vova", "Volkov", 1990, 1950));
        assertEquals("End date of career cannot be earlier than start date of career", exception.getMessage());
    }

    @Test
    @Rollback
    public void testTooLongCareer() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Player("Vova", "Volkov", 1800, 1950));
        assertEquals("Duration of career can`t be more than 100 years", exception.getMessage());
    }
}
