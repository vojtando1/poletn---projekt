package Commands;
import Game.*;

/**
 * Příkaz pro použití předmětu.
 * <p>
 * Tento příkaz umožňuje hráči použít předmět,
 * který má ve svém inventáři.
 * Pokud hráč daný předmět nevlastní,
 * vrátí se chybová hláška.
 * V opačném případě se zavolá metoda use()
 * daného předmětu.
 * </p>
 *
 * @author Vojta
 */
public class UseCommand implements Command {

    /**
     * Vykoná příkaz pro použití předmětu.
     *
     * @param game aktuální instance hry
     * @param argument název předmětu, který chce hráč použít
     * @return výsledek použití předmětu nebo chybová zpráva
     */
    @Override
    public String execute(Game game, String argument) {
        Item i = game.getPlayer().getItem(argument);

        if (i == null) {
            return "Tento předmět nemáš.";
        } else {
            return i.use(game.getPlayer(), game);
        }
    }

    /**
     * Určuje, zda má být hra po vykonání příkazu ukončena.
     *
     * @return false, protože tento příkaz hru neukončuje
     */
    @Override
    public boolean exit() {
        return false;
    }
}

