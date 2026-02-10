public interface Command {
    String execute(Game game, String argument);
    boolean exit();
}
