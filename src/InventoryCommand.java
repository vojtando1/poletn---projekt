public class InventoryCommand implements Command {
    public void execute(Game game, String argument) {
        System.out.println(game.getPlayer().inventoryToString());
    }
}
