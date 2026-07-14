package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    @Test
    void firstPlayerWins() {
        Game game = new Game();
        Player p1 = new Player(1, "Ivan", 10);
        Player p2 = new Player(2, "Petr", 5);
        game.register(p1);
        game.register(p2);

        int actual = game.round("Ivan", "Petr");

        assertEquals(1, actual);
    }

    @Test
    void secondPlayerWins() {
        Game game = new Game();
        game.register(new Player(1, "Ivan", 3));
        game.register(new Player(2, "Petr", 7));

        int actual = game.round("Ivan", "Petr");

        assertEquals(2, actual);
    }

    @Test
    void draw() {
        Game game = new Game();
        game.register(new Player(1, "Ivan", 7));
        game.register(new Player(2, "Petr", 7));

        int actual = game.round("Ivan", "Petr");

        assertEquals(0, actual);
    }

    @Test
    void firstPlayerNotRegistered() {
        Game game = new Game();
        game.register(new Player(2, "Petr", 7));

        assertThrows(NotRegisteredException.class, () -> game.round("Ivan", "Petr"));
    }

    @Test
    void secondPlayerNotRegistered() {
        Game game = new Game();
        game.register(new Player(1, "Ivan", 7));

        assertThrows(NotRegisteredException.class, () -> game.round("Ivan", "Petr"));
    }
}

