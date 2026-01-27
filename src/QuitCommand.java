public class QuitCommand implements Command {
    public void execute(Game game, String argument) {
        game.stop();
    }
}

