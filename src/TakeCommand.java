public class TakeCommand implements Command {
    public void execute(Game game, String argument) {
    Item i = game.getPlayer().getLocation().takeItem(argument);
    if (i == null) System.out.println("Takový předmět tu není.");
    else { game.getPlayer().addItem(i); System.out.println("Sebral jsi " + i.getName()); }
}
}

