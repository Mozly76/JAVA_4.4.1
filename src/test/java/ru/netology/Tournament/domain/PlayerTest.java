package ru.netology.Tournament.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Player player = new Player();

    @Test
    public void shouldSetId() {

        player.setId(1);

        int expected = 1;
        int actual = player.getId();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetName() {

        player.setName("Winner");

        String expected = "Winner";
        String actual = player.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStrength() {

        player.setStrength(100);

        int expected = 100;
        int actual = player.getStrength();

        assertEquals(expected, actual);
    }
}