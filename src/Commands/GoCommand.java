package Commands;

import Game.*;

public class GoCommand implements Command {
    @Override
    public String execute(Game game, String arg) {
        if (arg.isEmpty()) {
            return "Kam mám jít? (Např. 'jdi strazni_mistnost')";
        }


        Player player = game.getPlayer();
        Location current = player.getLocation();

        // Zkusíme najít východ podle ID, které hráč napsal
        Location next = current.getExit(arg);

        if (next == null) {
            return "Tudy cesta nevede nebo jsi zadal špatné ID místnosti. Možné východy: " + current.getExits();
        }
        if (next.getId().equals("portal")) {
            game.stop();
            return "Vstoupil jsi do portálu a unikl z pevnosti. VYHRÁL JSI!";
        }
        if (next.getId().equals("portal")) {
            Location dungeon = game.getData().findLocation("sklepeni");
            if (dungeon.getCharacter("golem") != null) {
                return "Portál je neaktivní. Golem stále žije!";
            }
        // Logika pro zamčené dveře
        if (next.isLocked()) {
            if (player.hasItem(next.getKey())) {
                System.out.println("Odemkl jsi dveře předmětem: " + next.getKey());
                next.setLocked(false);
            } else {
                return"Místnost je zamčená. Potřebuješ: " + next.getKey();
            }

            }
        }

        // Samotný přesun
        player.setLocation(next);
        return "Vcházíš do: " + next.getName();
    }


    @Override
    public boolean exit() {
        return false;
    }

}
