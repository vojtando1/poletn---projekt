package tests;

import Commands.GoCommand;
import Game.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Testovací třída pro ověření funkčnosti příkazu {@link GoCommand}.
 *
 * Testuje:
 *
 *     přesun do platné lokace
 *     pokus o přesun do neexistující lokace<
 *     že příkaz neukončuje hru
 *
 *
 *
 * @author Vojta
 */
class GoCommandTest {

    /**
     * Ověřuje, že hráč může přejít do existující lokace,
     * pokud je mezi lokacemi vytvořen východ.
     */
    @Test
    void execute_validExit() {

        Location a = new Location("a", "A", "Místnost A",
                false, null,
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Location b = new Location("b", "B", "Místnost B",
                false, null,
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        a.getExits().add("b");

        GameData data = new GameData();
        data.addLocation(a);
        data.addLocation(b);

        Game game = new Game(data);
        Main.game = game;

        game.getPlayer().setLocation(a);

        GoCommand cmd = new GoCommand();
        String result = cmd.execute(game, "b");

        assertEquals(b, game.getPlayer().getLocation());
        assertTrue(result.contains("Vcházíš"));
    }

    /**
     * Ověřuje, že při pokusu o přesun do neexistující lokace
     * zůstane hráč ve stejné místnosti.
     */
    @Test
    void execute_invalidExit() {

        Location a = new Location("a", "A", "Místnost A",
                false, null,
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        GameData data = new GameData();
        data.addLocation(a);

        Game game = new Game(data);
        game.getPlayer().setLocation(a);

        GoCommand cmd = new GoCommand();
        String result = cmd.execute(game, "neexistuje");

        assertEquals(a, game.getPlayer().getLocation());
        assertTrue(result.contains("Tudy cesta nevede"));
    }

    /**
     * Ověřuje, že příkaz {@link GoCommand} neukončuje hru.
     */
    @Test
    void exit() {
        GoCommand cmd = new GoCommand();
        assertFalse(cmd.exit());
    }
}
