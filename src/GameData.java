import com.google.gson.Gson;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Načítá herní data z JSON souboru uloženého v resources.
 * Slouží jako datový kontejner pro položky, postavy a lokace.
 */
public class GameData {

    public ArrayList<Item> items;
    public ArrayList<GameCharacter> characters;
    public ArrayList<Location> locations;

    /**
     * Načte JSON z resources a převede ho na objekt GameData pomocí Gson.
     *
     * @param resourcePath cesta k souboru (např. "/gamedata.json")
     * @return naplněný objekt GameData
     */
    public static GameData loadGameDataFromResources(String resourcePath) {

        Gson gson = new Gson();

        try (Reader reader = new FileReader(resourcePath)) {

            return gson.fromJson(
                    reader,
                    GameData.class
            );

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage(), e);
        }
    }

    /**
     * Najde lokaci podle ID.
     */
    public Location findLocation(String name) {
        for (Location l : locations) {
            if (l.name.equals(l.name)) {
                return l;
            }
        }
        throw new IllegalArgumentException("Neexistuje lokace s id: " + name);
    }
}