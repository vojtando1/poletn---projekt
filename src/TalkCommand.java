public class TalkCommand implements Command {
    public void execute(Game game, String argument) {
        GameCharacter c = game.getPlayer().getLocation().getCharacter(argument);
        if (c == null) System.out.println("Nikdo takový tu není.");
        else System.out.println(c.dialogue);
    }

}
