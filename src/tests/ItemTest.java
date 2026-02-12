package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Game.*;

/**
 * Testovací třída pro ověření funkčnosti třídy Item.
 *
 * Testuje použití předmětu "stary_svitek" a jeho efekt
 * na hráče (nastavení znalosti slabiny nepřítele).
 *
 * @author Vojta
 */
class ItemTest {

    /**
     * Ověřuje, že použití předmětu "stary_svitek":
     * - nastaví hráči vlastnost knowsWeakness na true
     * - vrátí text obsahující informaci o slabině
     */
    @Test
    void use_starySvitek_setsWeakness() {

        Item svitek = new Item("stary_svitek", "Starý svitek", "znalost");
        Player player = new Player("Test", null);

        String result = svitek.use(player, null);

        assertTrue(player.knowsWeakness);
        assertTrue(result.contains("slabinu"));
    }
}
