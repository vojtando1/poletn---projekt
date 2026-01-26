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


    public Location(String id, String name, String description, boolean locked, String key,
                    ArrayList<String> exits, ArrayList<Item> items, ArrayList<GameCharacter> characters) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.key = key;
        this.exits = (exits != null) ? exits : new ArrayList<>();
        this.items = (items != null) ? items : new ArrayList<>();
        this.characters = (characters != null) ? characters : new ArrayList<>();
    }


    // Přidat metodu pro kontrolu zda má klíč
        public boolean hasKey() {
            return key != null && !key.isEmpty();
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

    /**
     * Vypíše do konzole název lokace, její popis a dostupné východy.
     */
    public void describe() {
        System.out.println("\n== " + name + " ==");
        System.out.println(description);
        if (!exits.isEmpty()) {
            System.out.println("Východy: " + String.join(", ", exits));
        }
        if (!items.isEmpty()) {
            System.out.print("Předměty: ");
            for (Item item : items) {
                System.out.print(item.getName() + ", ");
            }
            System.out.println();
        }
    }

    /**
     * Pokusí se najít sousední lokaci podle zadaného ID.
     *
     * @param id ID cílové lokace.
     * @return Objekt Location, pokud cesta existuje, jinak null.
     */
    public Location getExit(String id) {
        if (exits == null || !exits.contains(id)) {
            return null;
        }
        return Main.game.getData().findLocation(id);
    }

    /**
     * Odstraní předmět z lokace a vrátí jej (např. při sebrání hráčem).
     *
     * @param id ID předmětu, který má být odebrán.
     * @return Objekt Item, pokud se v lokaci nachází, jinak null.
     */
    public Item takeItem(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                return items.remove(i); // remove(index) vrátí ten smazaný objekt
            }
        }
        return null;
    }

    /**
     * Vyhledá postavu v lokaci podle ID.
     *
     * @param id ID hledané postavy.
     * @return Objekt GameCharacter, pokud se v lokaci nachází, jinak null.
     */
    public GameCharacter getCharacter(String id) {
        for (GameCharacter c : characters) if (c.id.equals(id)) return c;
        return null;
    }
}