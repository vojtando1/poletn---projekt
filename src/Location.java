import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    String id;
    String name;
    String description;
    boolean locked;
    String key;
    ArrayList<String> exits;
    ArrayList<Item> items;
    ArrayList<GameCharacter> characters;


    public void describe() {
        System.out.println("\n== " + name + " ==");
        System.out.println(description);
    }


    public Location getExit(String id) {
        if (!exits.contains(id)) return null;
        return Main.game.getData().findLocation(id);
    }


    public Item takeItem(String id) {
        for (Item i : items) {
            if (i.id.equals(id)) {
                items.remove(i);
                return i;
            }
        }
        return null;
    }


    public GameCharacter getCharacter(String id) {
        for (GameCharacter c : characters) if (c.id.equals(id)) return c;
        return null;
    }
}
