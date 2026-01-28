public class UseCommand implements Command {
    public void execute(Game game, String argument) {
        Item i = game.getPlayer().getItem(argument);
        if (i == null) System.out.println("Tento předmět nemáš.");
        else i.use(game.getPlayer(), game);
    }
}

