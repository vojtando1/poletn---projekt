import java.util.ArrayList;


public class Location {
    private String id;
    private String name;
    private String description;
    private boolean locked;
    private String key;
    private ArrayList<String> exits;
    private ArrayList<Item> items;
    private ArrayList<GameCharacter> characters;

    public Location(String id, String name, String description, boolean locked, String key, ArrayList<String> exits, ArrayList<Item> items, ArrayList<GameCharacter> characters) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.key = key;
        // Pokud je vstup null, vytvoř prázdný seznam
        this.exits = (exits != null) ? exits : new ArrayList<>();
        this.items = (items != null) ? items : new ArrayList<>();
        this.characters = (characters != null) ? characters : new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<String> getExits() {
        return exits;
    }

    public void setExits(ArrayList<String> exits) {
        this.exits = exits;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<GameCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<GameCharacter> characters) {
        this.characters = characters;
    }

    public void describe() {
        System.out.println("\n== " + name + " ==");
        System.out.println(description);
        System.out.println("Východy: " + String.join(", ", exits));
    }


    public Location getExit(String id) {
        if (exits == null || !exits.contains(id)) {
            return null;
        }
        return Main.game.getData().findLocation(id);
    }


    public Item takeItem(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                return items.remove(i); // remove(index) vrátí ten smazaný objekt
            }
        }
        return null;
    }


    public GameCharacter getCharacter(String id) {
        for (GameCharacter c : characters) if (c.id.equals(id)) return c;
        return null;
    }
}
