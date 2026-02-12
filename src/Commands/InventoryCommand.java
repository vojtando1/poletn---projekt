package Commands;

import Game.*;

/**
 * Příkaz zobrazující obsah inventáře hráče.
 * Tento příkaz vypíše všechny předměty,
 * které má hráč aktuálně u sebe.
 *
 * Inventář je důležitý pro řešení herních situací
 * (odemčení místností, boj s nepřítelem apod.).
 *
 * @author Vojta
 */
public class InventoryCommand implements Command {

    /**
     * Vykoná příkaz pro zobrazení inventáře.
     *
     * @param game aktuální instance hry
     * @param argument argument příkazu (není využíván)
     * @return textová reprezentace inventáře hráče
     */
    @Override
    public String execute(Game game, String argument) {
        return game.getPlayer().inventoryToString();
    }

    /**
     * Určuje, zda příkaz ukončuje hru.
     *
     * @return false – příkaz inventář hru neukončuje
     */
    @Override
    public boolean exit() {
        return false;
    }
}