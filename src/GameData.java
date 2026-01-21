import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
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

        try (InputStream is = GameData.class.getResourceAsStream(resourcePath)) {

            if (is == null) {
                throw new IllegalStateException(
                        "Nenalezen resource: " + resourcePath +
                                " (zkontroluj src/main/resources)"
                );
            }

            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    GameData.class
            );

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage(), e);
        }
    }

    /**
     * Najde lokaci podle ID.
     */
    public Location findLocation(String id) {
        for (Location l : locations) {
            if (l.id.equals(id)) {
                return l;
            }
        }
        throw new IllegalArgumentException("Neexistuje lokace s id: " + id);
    }
}