package Commands;

import Game.*;

/**
 * Příkaz zobrazující nápovědu ke hře.
 * <p>
 * Tento příkaz vypíše seznam dostupných příkazů,
 * které může hráč během hry použít.
 * </p>
 *
 * Slouží především k orientaci hráče v herních mechanikách.
 * </p>
 *
 * @author Vojta
 */
public class HelpCommand implements Command {

    /**
     * Vykoná příkaz nápovědy.
     *
     * @param game aktuální instance hry
     * @param argument argument příkazu (není využíván)
     * @return text obsahující seznam dostupných příkazů
     */
    @Override
    public String execute(Game game, String argument) {
        return "Příkazy: jdi, vezmi, použij, mluv, utoč, inventář, konec, prozkoumej";
    }

    /**
     * Určuje, zda příkaz ukončuje hru.
     *
     * @return false – příkaz help hru neukončuje
     */
    @Override
    public boolean exit() {
        return false;
    }
}
