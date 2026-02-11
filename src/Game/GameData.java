package Game;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import Commands.*;

/**
 * Načítá herní data z JSON souboru uloženého v resources.
 * Slouží jako datový kontejner pro položky, postavy a lokace.
 * @author Vojta, Matej Chaloupka
 */
public class GameData {

    public ArrayList<Item> items;
    public ArrayList<GameCharacter> characters;

    /**
     * Načte JSON z resources a převede ho na objekt Game.GameData pomocí Gson.
     *
     * @param resourcePath cesta k souboru (např. "/gamedata.json")
     * @return naplněný objekt Game.GameData
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


    private ArrayList<Location> locations = new ArrayList<>();

    /**
     * Přidá novou lokaci do herních dat.
     *
     * @param location lokace, která má být přidána
     * @throws IllegalArgumentException pokud je lokace null
     */
    public void addLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Lokace nesmí být null");
        }
        locations.add(location);
    }

    /**
     * Vyhledá lokaci podle jejího identifikátoru.
     *
     * @param id identifikátor hledané lokace
     * @return nalezená lokace nebo null, pokud neexistuje
     */
    public Location findLocation(String id) {
        for (Location l : locations) {
            if (l.getId().equals(id)) {
                return l;
            }
            if (id == null) return null;
        }
        return null;
    }
}