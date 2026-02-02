import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private final GameData data;
    private final Player player;
    private final HashMap<String, Command> commands = new HashMap<>();
    private boolean running = true;


    public Game(GameData data) {
        this.data = data;
        this.player = new Player("Vojta", data.findLocation("vstupni_sin"));
        registerCommands();
    }


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
    }


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


    private void handleInput(String input) {
        if (input.isBlank()) return;
        String[] parts = input.toLowerCase().split(" ", 2);
        Command cmd = commands.get(parts[0]);
        if (cmd == null) {
            System.out.println("Neznámý příkaz. Napiš 'pomoc'.");
            return;
        }
        String arg = parts.length > 1 ? parts[1] : "";
        cmd.execute(this, arg);
    }


    public Player getPlayer() { return player; }
    public GameData getData() { return data; }
    public boolean stop() {
        running = false;
        return running;
    }
}
