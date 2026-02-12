package Commands;
import Game.*;

/**
 * Příkaz umožňující hráči zaútočit na nepřítele v aktuální lokaci.
 * Tento příkaz je primárně určen pro boj s bossem hry – Golemem.
 * Hráč může Golema porazit pouze v případě, že:
 * vlastní předmět "stary_mec"
 * zná slabinu Golema (proměnná knowsWeakness)
 *
 * Pokud hráč nesplňuje podmínky, Golem mu způsobí zranění.
 * Při ztrátě všech životů hra končí prohrou.
 *
 * @author Vojta
 */
public class AttackCommand implements Command {

    /**
     * Provede útok hráče na postavu v aktuální lokaci.
     *
     * @param game     aktuální instance hry obsahující herní data a stav hráče
     * @param argument argument příkazu (aktuálně není využíván)
     * @return textová zpráva popisující výsledek útoku
     */
    @Override
    public String execute(Game game, String argument) {

        // Získání aktuální lokace hráče
        Location loc = game.getPlayer().getLocation();

        // Pokus o nalezení Golema v lokaci
        GameCharacter g = loc.getCharacter("golem");

        if (g == null) {
            return "Není na koho útočit.";
        }

        Player p = game.getPlayer();

        // Kontrola, zda má hráč potřebné vybavení a znalosti
        if (!p.hasItem("stary_mec") || !p.knowsWeakness) {

            // Hráč utrpí zranění
            p.damage(5);

            // Pokud hráč zemře, hra končí
            if (!p.isAlive()) {
                game.stop();
                return "Golem tě zabil. Prohrál jsi.";
            }

            return "Útočíš, ale Golem je příliš silný! Ztrácíš 5 HP (HP: " + p.getHealth() + ")";
        }

        // Golem je poražen
        loc.getCharacters().remove(g);

        return "Porazil jsi Golema! Objevuje se portál.";
    }

    /**
     * Určuje, zda příkaz ukončuje hru.
     *
     * @return false – tento příkaz hru přímo neukončuje
     */
    @Override
    public boolean exit() {
        return false;
    }
}