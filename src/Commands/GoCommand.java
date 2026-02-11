package Commands;

import Game.*;

/**
 * Příkaz umožňující hráči přesun mezi lokacemi.
 * <p>
 * Hráč zadá ID místnosti, do které se chce přesunout.
 * Příkaz ověřuje:
 * <ul>
 *     <li>zda byl zadán argument</li>
 *     <li>zda daný východ existuje</li>
 *     <li>zda není místnost zamčená</li>
 *     <li>zda má hráč potřebný klíč</li>
 * </ul>
 * Speciální logika je implementována pro portál, který může ukončit hru výhrou.
 * </p>
 *
 * @author Vojta
 */
public class GoCommand implements Command {

    /**
     * Provede přesun hráče do jiné lokace.
     *
     * @param game aktuální instance hry
     * @param arg ID místnosti, do které se chce hráč přesunout
     * @return textová zpráva informující o výsledku přesunu
     */
    @Override
    public String execute(Game game, String arg) {

        if (arg.isEmpty()) {
            return "Kam mám jít? (Např. 'jdi strazni_mistnost')";
        }

        Player player = game.getPlayer();
        Location current = player.getLocation();

        // Najdeme cílovou lokaci podle ID
        Location next = current.getExit(arg);

        if (next == null) {
            return "Tudy cesta nevede nebo jsi zadal špatné ID místnosti. Možné východy: "
                    + current.getExits();
        }

        // Kontrola zamčené místnosti
        if (next.isLocked()) {
            if (player.hasItem(next.getKey())) {
                System.out.println("Odemkl jsi dveře předmětem: " + next.getKey());
                next.setLocked(false);
            } else {
                return "Místnost je zamčená. Potřebuješ: " + next.getKey();
            }

            // Speciální logika pro portál
            if (next.getId().equals("portal")) {
                game.stop();
                return "Vstoupil jsi do portálu a unikl z pevnosti. VYHRÁL JSI!";
            }

            if (next.getId().equals("portal")) {
                Location dungeon = game.getData().findLocation("sklepeni");
                if (dungeon.getCharacter("golem") != null) {
                    return "Portál je neaktivní. Golem stále žije!";
                }
            }
        }

        // Samotný přesun hráče
        player.setLocation(next);
        return "Vcházíš do: " + next.getName();
    }

    /**
     * Určuje, zda příkaz ukončuje hru.
     *
     * @return false – příkaz jdi hru neukončuje
     */
    @Override
    public boolean exit() {
        return false;
    }
}
