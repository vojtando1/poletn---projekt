package tests;
import Commands.GoCommand;
import Game.*;

import static Game.Main.game;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


class GoCommandTest {

    @Test
    void execute_validExit() {

        // vytvoření lokací
        Location a = new Location("a", "A", "Místnost A", false, null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );

        Location b = new Location("b", "B", "Místnost B", false, null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );

        // propojení
        a.getExits().add("b");

        // nastavení GameData (simulace)

        GameData data = new GameData();
        data.addLocation(a);
        data.addLocation(b);
        game = game;
        Game game = new Game(data);
        Main.game = game;
        game.getPlayer().setLocation(a);

        GoCommand cmd = new GoCommand();

        String result = cmd.execute(game, "b");

        assertEquals(b, game.getPlayer().getLocation());
        assertTrue(result.contains("Vcházíš"));
    }

    @Test
    void execute_invalidExit() {
        Location a = new Location("a", "A", "Místnost A", false, null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );

        GameData data = new GameData();
        data.addLocation(a);

        Game game = new Game(data);
        game.getPlayer().setLocation(a);

        GoCommand cmd = new GoCommand();

        String result = cmd.execute(game, "neexistuje");

        assertEquals(a, game.getPlayer().getLocation());
        assertTrue(result.contains("Tudy cesta nevede"));
    }

    @Test
    void exit() {
        GoCommand cmd = new GoCommand();
        assertFalse(cmd.exit());
    }
}
