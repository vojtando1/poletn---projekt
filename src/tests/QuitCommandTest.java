package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Commands.QuitCommand;
import Game.*;

class QuitCommandTest {

    @Test
    void exit_stopsGame() {
        GameData data = new GameData();
        Game game = new Game(data);
        Main.game = game;

        QuitCommand cmd = new QuitCommand();
        cmd.execute(game, "");

        assertFalse(game.stop());
    }
}