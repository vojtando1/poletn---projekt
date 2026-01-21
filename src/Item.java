public class Item {
    String id;
    String name;
    String type;


    public void use(Player p, Game g) {
        if (id.equals("stary_svit")) {
            p.knowsWeakness = true;
            System.out.println("Dozvěděl ses slabinu Golema.");
        }
    }
}
