public class HelpCommand implements Command {
    public void execute(Game game, String argument) {
        System.out.println("Příkazy: jdi, vezmi, použij, mluv, utoč, inventář, konec");
    }
}
