package Commands;
import Game.*;
public class TalkCommand implements Command {
    public String execute(Game game, String argument) {
        GameCharacter c = game.getPlayer().getLocation().getCharacter(argument);
        if (c == null) System.out.println("Nikdo takový tu není.");
        return c.dialogue;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
