package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Game.*;

import java.util.ArrayList;

class LocationTest {
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