public class QuitCommand implements Command {
    Game game;
    public String execute(Game game, String argument) {
        this.game = game;
        return "Konec";
    }

    @Override
    public boolean exit() {
        return game.stop();
    }
}
