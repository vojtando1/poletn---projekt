package Game;
import java.util.ArrayList;

/**
 * Třída reprezentující hráče.
 * Hráč má své jméno, aktuální lokaci,
 * inventář předmětů a životy.
 * Uchovává také informaci o tom,
 * zda zná slabinu Golema,
 * což je důležité pro úspěšné dokončení hry.
 *
 * @author Vojta
 */
public class Player {
    private  String name;
    private Location location;
    public boolean knowsWeakness = false;
    private  ArrayList<Item> inventory = new ArrayList<>();


    public Player(String name, Location start) {
        this.name = name;
        this.location = start;
    }


    public Location getLocation() {
        return location; }
    public void setLocation(Location l) {
        location = l; }


    public void addItem(Item i) {
        inventory.add(i); }

    /**
     * Vyhledá předmět v inventáři podle ID.
     *
     * @param id identifikátor předmětu
     * @return nalezený předmět nebo null
     */
    public Item getItem(String id) {
        if (id == null) return null;

        for (Item i : inventory) {
            if (id.equals(i.getId())) {
                return i;
            }
        }
        return null;
    }

    /**
     * Zjistí, zda hráč vlastní předmět s daným ID.
     *
     * @param id identifikátor předmětu
     * @return true pokud předmět vlastní
     */
    public boolean hasItem(String id) {
        return getItem(id) != null;
    }


    /**
     * Vrátí textovou reprezentaci inventáře.
     *
     * @return seznam předmětů nebo informace o prázdném inventáři
     */
    public String inventoryToString() {
        if (inventory.isEmpty()) return "Inventář je prázdný.";
        StringBuilder sb = new StringBuilder("Inventář: ");
        for (Item i : inventory) sb.append(i.getName()).append(", ");
        return sb.toString();
    }
    private int health = 10;

    /**
     * Odečte hráči životy.
     *
     * @param dmg počet poškození
     */

    public void damage(int dmg) {
        health -= dmg;
    }
    /**
     * Zjistí, zda je hráč naživu.
     *
     * @return true pokud má více než 0 životů
     */
    public boolean isAlive() {
        return health > 0;
    }
    /**
     * Vrací aktuální počet životů hráče.
     *
     * @return počet životů
     */
    public int getHealth() {
        return health;
    }
}