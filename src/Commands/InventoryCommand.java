package Commands;
import Game.*;
public class InventoryCommand implements Command {
    public String execute(Game game, String argument) {
        return game.getPlayer().inventoryToString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}