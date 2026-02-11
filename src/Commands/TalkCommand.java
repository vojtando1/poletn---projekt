package Commands;
import Game.*;

/**
 * Příkaz pro komunikaci s postavou.
 * <p>
 * Tento příkaz umožňuje hráči promluvit si s postavou,
 * která se nachází na aktuální lokaci.
 * Pokud postava existuje, vrátí se její dialog.
 * Pokud postava na daném místě není, vypíše se chybová hláška.
 * </p>
 *
 * @author Vojta
 */
public class TalkCommand implements Command {

    /**
     * Vykoná příkaz promluvení s postavou.
     *
     * @param game aktuální instance hry
     * @param argument jméno postavy, se kterou chce hráč mluvit
     * @return dialog dané postavy
     */
    @Override
    public String execute(Game game, String argument) {
        GameCharacter c = game.getPlayer().getLocation().getCharacter(argument);

        if (c == null) {
            System.out.println("Nikdo takový tu není.");
        }

        return c.dialogue;
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