package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Game.*;

class ItemTest {
    @Test
    void use_starySvitek_setsWeakness() {
        Item svitek = new Item("stary_svitek", "Starý svitek", "znalost");
        Player player = new Player("Test", null);

        String result = svitek.use(player, null);

        assertTrue(player.knowsWeakness);
        assertTrue(result.contains("slabinu"));
    }
}