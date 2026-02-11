package Game;
import Commands.*;
import java.util.ArrayList;

public class Player {
    private  String name;
    private Location location;
    public boolean knowsWeakness = false;
    private  ArrayList<Item> inventory = new ArrayList<>();


    public Player(String name, Location start) {
        this.name = name;
        this.location = start;
    }


    public Location getLocation() { return location; }
    public void setLocation(Location l) { location = l; }


    public void addItem(Item i) { inventory.add(i); }


    public Item getItem(String id) {
        return inventory.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
    }


    public boolean hasItem(String id) {
        return getItem(id) != null;
    }


    public String inventoryToString() {
        if (inventory.isEmpty()) return "Inventář je prázdný.";
        StringBuilder sb = new StringBuilder("Inventář: ");
        for (Item i : inventory) sb.append(i.getName()).append(", ");
        return sb.toString();
    }
    private int health = 10;

    public void damage(int dmg) {
        health -= dmg;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }
}