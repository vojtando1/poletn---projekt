public class TakeCommand implements Command {
    public String execute(Game game, String argument) {
    Item i = game.getPlayer().getLocation().takeItem(argument);
    if (i == null) System.out.println("Takový předmět tu není.");
    else { game.getPlayer().addItem(i); }
    return "Sebral jsi " + i.getName();
}

    @Override
    public boolean exit() {
        return false;
    }
}

