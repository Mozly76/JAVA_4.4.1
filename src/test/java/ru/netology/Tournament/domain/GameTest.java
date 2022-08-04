package ru.netology.Tournament.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game registeredPlayers = new Game();

    Player player1 = new Player(1, "Winner", 109);
    Player player2 = new Player(2, "Star", 110);
    Player player3 = new Player(3, "GodGame", 111);
    Player player4 = new Player(4, "MasterGame", 109);
    Player player5 = new Player(5, "Champion", 112);


    @Test
    public void shouldCompareStrengthOfTwoPlayersIfBothPlayersHaveEqualStrength() {

        registeredPlayers.register(player1);
        registeredPlayers.register(player4);

        int expected = 0;
        int actual = registeredPlayers.round(player1.getName(), player4.getName());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareStrengthOfTwoPlayersIfFirstPlayerStrongerThanSecond() {

        registeredPlayers.register(player3);
        registeredPlayers.register(player2);

        int expected = 1;
        int actual = registeredPlayers.round(player3.getName(), player2.getName());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareStrengthOfTwoPlayersIfFirstPlayerWeakerThanSecond() {

        registeredPlayers.register(player1);
        registeredPlayers.register(player5);

        int expected = 2;
        int actual = registeredPlayers.round(player1.getName(), player5.getName());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareTheStrengthOfTheTwoPlayersIfTheFirstPlayerIsNotRegistered() {

        registeredPlayers.register(player1);
        registeredPlayers.register(player2);

        assertThrows(NotRegisteredException.class, () -> {
            registeredPlayers.round(player3.getName(), player2.getName());
        });
    }

    @Test
    public void shouldCompareStrengthOfTwoPlayersIfSecondOfPlayersIsNotRegistered() {

        registeredPlayers.register(player3);
        registeredPlayers.register(player4);

        assertThrows(NotRegisteredException.class, () -> {
            registeredPlayers.round(player3.getName(), player5.getName());
        });
    }

    @Test
    public void shouldCompareStrengthOfTwoPlayersIfBothPlayersAreNotRegistered() {

        registeredPlayers.register(player1);
        registeredPlayers.register(player2);

        assertThrows(NotRegisteredException.class, () -> {
            registeredPlayers.round(player3.getName(), player4.getName());
        });
    }
}