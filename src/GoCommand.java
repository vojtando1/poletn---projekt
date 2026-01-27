public class GoCommand implements Command{
    @Override
    public void execute(Game game, String arg) {
        if (arg.isEmpty()) {
            System.out.println("Kam mám jít? (Např. 'jdi strazni_mistnost')");
            return;
        }

        Player player = game.getPlayer();
        Location current = player.getLocation();

        // Zkusíme najít východ podle ID, které hráč napsal
        Location next = current.getExit(arg);

        if (next == null) {
            System.out.println("Tudy cesta nevede nebo jsi zadal špatné ID místnosti.");
            System.out.println("Možné východy: " + current.getExits());
            return;
        }

        // Logika pro zamčené dveře
        if (next.isLocked()) {
            if (player.hasItem(next.getKey())) {
                System.out.println("Odemkl jsi dveře předmětem: " + next.getKey());
                next.setLocked(false);
            } else {
                System.out.println("Místnost je zamčená. Potřebuješ: " + next.getKey());
                return;
            }
        }

        // Samotný přesun
        player.setLocation(next);
        System.out.println("Vcházíš do: " + next.getName());
    }
}
