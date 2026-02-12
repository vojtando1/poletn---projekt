package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Game.*;

/**
 * Testovací třída ověřující práci s inventářem hráče.
 * Testuje přidání předmětu do inventáře a jeho následné
 * vyhledání pomocí metod {@link Player#hasItem(String)}
 * a {@link Player#getItem(String)}.
 *
 * @author Vojta
 */
class InventoryCommandTest {

    /**
     * Ověřuje, že:
     * předmět lze přidat do inventáře
     * metoda hasItem vrací true pro existující předmět
     * metoda getItem vrátí správný objekt
     */
    @Test
    void addItem_and_hasItem() {

        Player p = new Player("Test", null);
        Item item = new Item("mec", "Meč", "zbran");

        p.addItem(item);

        assertTrue(p.hasItem("mec"));
        assertNotNull(p.getItem("mec"));
    }
}