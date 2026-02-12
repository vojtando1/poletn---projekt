package Commands;

import Game.*;

/**
 * Příkaz umožňující hráči detailně prozkoumat aktuální lokaci.
 * Tento příkaz vypíše:
 * název a popis místnosti
 * seznam předmětů v místnosti
 * seznam postav v místnosti
 * dostupné východy
 * informaci o tom, zda je místnost zamčená
 * Slouží k získání kompletního přehledu o aktuální herní situaci.
 *
 * @author Vojta
 */
public class ExploreCommand implements Command {

    /**
     * Provede prozkoumání aktuální lokace hráče.
     *
     * @param game aktuální instance hry
     * @param argument argument příkazu (není využíván)
     * @return text obsahující detailní informace o lokaci
     */
    @Override
    public String execute(Game game, String argument) {

        Location l = game.getPlayer().getLocation();
        StringBuilder sb = new StringBuilder();

        sb.append("Rozhlížíš se po místnosti...\n");
        sb.append(l.getName()).append("\n");
        sb.append(l.getDescription()).append("\n\n");

        // Předměty
        if (l.getItems().isEmpty()) {
            sb.append("Žádné předměty tu nejsou.\n");
        } else {
            sb.append("Předměty v místnosti:\n");
            for (Item i : l.getItems()) {
                if (i == null) continue;
                sb.append("- ").append(i.getId()).append(" (").append(i.getName()).append(")\n");
            }
        }

        // Postavy
        if (l.getCharacters().isEmpty()) {
            sb.append("\nŽádné postavy tu nejsou.\n");
        } else {
            sb.append("\nPostavy v místnosti:\n");
            for (GameCharacter c : l.getCharacters()) {
                sb.append("- ").append(c.getId()).append(" (").append(c.getName()).append(")\n");
            }
        }

        // Východy
        sb.append("\nVýchody: ").append(String.join(", ", l.getExits()));

        // Zamčení
        if (l.isLocked()) {
            sb.append("\n⚠ Místnost je zamčená, potřebuješ: ").append(l.getKey());
        }

        return sb.toString();
    }

    /**
     * Určuje, zda příkaz ukončuje hru.
     *
     * @return false – příkaz prozkoumej hru neukončuje
     */
    @Override
    public boolean exit() {
        return false;
    }
}
