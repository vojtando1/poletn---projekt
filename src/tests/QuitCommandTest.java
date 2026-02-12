package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Commands.QuitCommand;
import Game.*;

/**
 * Testovací třída pro ověření funkčnosti příkazu QuitCommand.
 *
 * Testuje, zda příkaz správně reaguje na ukončení hry.
 *
 * @author Vojta
 */
class QuitCommandTest {

    /**
     * Ověřuje, že po vykonání příkazu quit
     * dojde k vyvolání ukončení hry.
     */
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