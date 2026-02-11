package Commands;

import Game.*;

/**
 * Příkaz pro sebrání předmětu z aktuální lokace.
 * <p>
 * Hráč zadá ID předmětu, který chce sebrat.
 * Pokud se předmět v místnosti nachází a je přenosný,
 * je přidán do inventáře hráče.
 * </p>
 *
 * @author Vojta
 */
public class TakeCommand implements Command {

    /**
     * Pokusí se sebrat předmět z aktuální lokace hráče.
     *
     * @param game aktuální instance hry
     * @param argument ID předmětu, který chce hráč sebrat
     * @return zpráva informující o výsledku akce
     */
    @Override
    public String execute(Game game, String argument) {
        Item i = game.getPlayer().getLocation().takeItem(argument);

        if (argument == null || argument.isEmpty()) {
            return "Jaký předmět chceš sebrat?";
        } else {
            game.getPlayer().addItem(i);
        }

        return "Sebral jsi " + i.getName();
    }

    /**
     * Tento příkaz neukončuje hru.
     *
     * @return vždy false
     */
    @Override
    public boolean exit() {
        return false;
    }
}