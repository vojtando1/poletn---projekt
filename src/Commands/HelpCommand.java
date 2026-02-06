package Commands;

import Game.*;

public class HelpCommand implements Command {
    public String execute(Game game, String argument) {
        return "Příkazy: jdi, vezmi, použij, mluv, utoč, inventář, konec, prozkoumej";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
