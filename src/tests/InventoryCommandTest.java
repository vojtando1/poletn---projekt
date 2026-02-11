package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Game.*;

class InventoryCommandTest {

    @Test
    void addItem_and_hasItem() {
        Player p = new Player("Test", null);
        Item item = new Item("mec", "Meč", "zbran");

        p.addItem(item);

        assertTrue(p.hasItem("mec"));
        assertNotNull(p.getItem("mec"));
    }
}