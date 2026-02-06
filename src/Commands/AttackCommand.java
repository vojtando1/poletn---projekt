package Commands;
import Game.*;

public class AttackCommand implements Command {
    @Override
    public String execute(Game game, String argument) {
        Location loc = game.getPlayer().getLocation();
        GameCharacter g = loc.getCharacter("golem");

        if (g == null) {
            return "Není na koho útočit.";
        }

        Player p = game.getPlayer();

        if (!p.hasItem("stary_mec") || !p.knowsWeakness) {
            p.damage(5);

            if (!p.isAlive()) {
                game.stop();
                return "Golem tě zabil. Prohrál jsi.";
            }

            return "Útočíš, ale Golem je příliš silný! Ztrácíš 5 HP (HP: "
                    + p.getHealth() + ")";
        }

        loc.getCharacters().remove(g);
        return "Porazil jsi Golema! Objevuje se portál.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}