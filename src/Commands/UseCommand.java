package Commands;

import Game.*;

public class UseCommand implements Command {
    public String execute(Game game, String argument) {
        Item i = game.getPlayer().getItem(argument);
        if (i == null) return "Tento předmět nemáš.";
        else  return i.use(game.getPlayer(), game);
    }

    @Override
    public boolean exit() {
        return false;
    }
}

