public class AttackCommand implements Command {
    public String execute(Game game, String argument) {
        GameCharacter g = game.getPlayer().getLocation().getCharacter("golem");
        if (g == null) {
            return "Není na koho útočit.";
        }
        if (!game.getPlayer().hasItem("stary_mec") || !game.getPlayer().knowsWeakness) {
            return "Nemáš vybavení nebo znalosti k poražení Golema.";
        }
        game.stop();
        return "Porazil jsi Golema! Objevuje se portál. Vyhrál jsi!";

    }

    @Override
    public boolean exit() {
        return false;
    }
}
