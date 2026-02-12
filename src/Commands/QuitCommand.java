package Commands;

import Game.*;

/**
 * Příkaz pro ukončení hry.
 * Tento příkaz nastaví stav hry na ukončený.
 * Po jeho vykonání herní smyčka skončí.
 *
 * @author Vojta
 */
public class QuitCommand implements Command {

    /** Instance hry, která má být ukončena */
    Game game;

    /**
     * Vykoná příkaz pro ukončení hry.
     *
     * @param game aktuální instance hry
     * @param argument argument příkazu (není využíván)
     * @return text informující o ukončení hry
     */
    @Override
    public String execute(Game game, String argument) {
        this.game = game;
        return "Konec";
    }

    /**
     * Určuje, zda má být hra po vykonání příkazu ukončena.
     *
     * @return true pokud byla hra úspěšně zastavena
     */
    @Override
    public boolean exit() {
        return game.stop();
    }
}