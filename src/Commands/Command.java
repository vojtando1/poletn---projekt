package Commands;
import Game.Game;

/**
 * Rozhraní představující obecný příkaz ve hře.
 * <p>
 * Každý příkaz ve hře (např. jdi, vezmi, použij, útoč, konec)
 * implementuje toto rozhraní. Díky tomu může hra pracovat
 * s příkazy jednotným způsobem.
 * </p>
 *
 * Implementující třídy musí definovat:
 * <ul>
 *     <li>logiku provedení příkazu</li>
 *     <li>informaci, zda příkaz ukončuje hru</li>
 * </ul>
 *
 * @author Vojta
 */
public interface Command {

    /**
     * Provede konkrétní herní příkaz.
     *
     * @param game aktuální instance hry obsahující stav hráče a světa
     * @param argument textový argument zadaný uživatelem (např. cíl pohybu)
     * @return textová odpověď hry, která se zobrazí hráči
     */
    String execute(Game game, String argument);

    /**
     * Určuje, zda příkaz ukončuje hru.
     *
     * @return true pokud příkaz ukončuje hru, jinak false
     */
    boolean exit();
}