package Game;

import java.util.HashMap;
import java.util.Scanner;
import Commands.*;

/**
 * Hlavní třída reprezentující běh hry.
 * Tato třída zajišťuje inicializaci hry,
 * registraci příkazů, zpracování vstupu hráče
 * a řízení herní smyčky.
 * Uchovává také instanci hráče a herních dat.
 *
 * @author Vojta
 */
public class Game {

    private final GameData data;
    private final Player player;
    private final HashMap<String, Command> commands = new HashMap<>();
    private boolean running = true;

    /**
     * Vytvoří novou instanci hry.
     *
     * @param data herní data potřebná pro běh hry
     */
    public Game(GameData data) {
        this.data = data;
        this.player = new Player("Vojta", data.findLocation("vstupni_sin"));
        registerCommands();
    }

    /**
     * Zaregistruje všechny dostupné herní příkazy.
     */
    private void registerCommands() {
        commands.put("jdi", new GoCommand());
        commands.put("vezmi", new TakeCommand());
        commands.put("pouzij", new UseCommand());
        commands.put("použij", new UseCommand());
        commands.put("mluv", new TalkCommand());
        commands.put("inventar", new InventoryCommand());
        commands.put("inventář", new InventoryCommand());
        commands.put("utoc", new AttackCommand());
        commands.put("utoč", new AttackCommand());
        commands.put("konec", new QuitCommand());
        commands.put("pomoc", new HelpCommand());
        commands.put("prozkoumej", new ExploreCommand());
    }

    /**
     * Spustí herní smyčku.
     * <p>
     * Opakovaně vypisuje popis aktuální lokace,
     * načítá vstup hráče a předává jej ke zpracování.
     * Smyčka běží, dokud není hra ukončena.
     * </p>
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vítej ve hře Prokletí kamenného Golema");

        while (running) {
            player.getLocation().describe();
            System.out.print("> ");
            String input = sc.nextLine();
            handleInput(input);
        }
    }

    /**
     * Zpracuje vstup hráče.
     *
     * @param input text zadaný hráčem
     */
    private void handleInput(String input) {
        if (input.isBlank()) return;

        String[] parts = input.toLowerCase().split(" ", 2);
        Command cmd = commands.get(parts[0]);

        if (cmd == null) {
            System.out.println("Neznámý příkaz. Napiš 'pomoc'.");
            return;
        }

        String arg = parts.length > 1 ? parts[1] : "";
        String result = cmd.execute(this, arg);

        if (result != null && !result.isBlank()) {
            System.out.println(result);
        }

        if (cmd.exit()) {
            running = false;
        }
    }

    public Player getPlayer() {
        return player;
    }

    public GameData getData() {
        return data;
    }

    /**
     * Ukončí hru.
     *
     * @return aktuální stav hry (false po ukončení)
     */
    public boolean stop() {
        running = false;
        return running;
    }
}