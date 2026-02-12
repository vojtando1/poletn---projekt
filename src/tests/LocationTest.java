package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Game.*;

import java.util.ArrayList;

/**
 * Testovací třída pro ověření práce s předměty v lokaci.
 *
 * Testuje metodu takeItem() ve třídě Location.
 * Ověřuje správné odebrání existujícího předmětu
 * i chování při pokusu o odebrání neexistujícího předmětu.
 *
 * @author Vojta
 */
class LocationTest {

    /**
     * Ověřuje, že pokud předmět v lokaci existuje:
     * - metoda takeItem vrátí správný objekt
     * - předmět je odstraněn ze seznamu předmětů
     */
    @Test
    void takeItem_existingItem() {

        Item item = new Item("klic", "Klíč", "klic");
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);

        Location loc = new Location(
                "mistnost", "Místnost", "Popis",
                false, null,
                new ArrayList<>(), items, new ArrayList<>()
        );

        Item taken = loc.takeItem("klic");

        assertNotNull(taken);
        assertEquals("klic", taken.getId());
        assertTrue(loc.getItems().isEmpty());
    }

    /**
     * Ověřuje, že pokud předmět v lokaci neexistuje,
     * metoda takeItem vrátí null.
     */
    @Test
    void takeItem_nonExistingItem() {

        Location loc = new Location(
                "mistnost", "Místnost", "Popis",
                false, null,
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );

        Item taken = loc.takeItem("neco");

        assertNull(taken);
    }
}