package Commands;

import Game.*;

public class TakeCommand implements Command {

    @Override
    public String execute(Game game, String argument) {
        Item i = game.getPlayer().getLocation().takeItem(argument);

        if (i == null) {
            return "Takový předmět tu není nebo jej nelze sebrat.";
        }
        else
          game.getPlayer().addItem(i);
        return "Sebral jsi " + i.getName();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
