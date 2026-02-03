public class AttackCommand implements Command {public void execute(Game game, String argument) {
    GameCharacter g = game.getPlayer().getLocation().getCharacter("golem");
    if (g == null) {
        System.out.println("Není na koho útočit.");
        return;
    }
    if (!game.getPlayer().hasItem("stary_mec") || !game.getPlayer().knowsWeakness) {
        System.out.println("Nemáš vybavení nebo znalosti k poražení Golema.");
        return;
    }
    System.out.println("Porazil jsi Golema! Objevuje se portál. Vyhrál jsi!");
    game.stop();
}

}
