package Game;

public class Item {
    private String id;
    private String name;
    private String type;

    /**
     * Pouzije predmet z inventare hrace.
     * <p>
     * Tato metoda zpracovava logiku pouziti specifickych predmetu.
     * Napriklad pri pouziti "stary_svitek" se hrac dozvi slabinu Golema,
     * coz je klicove pro uspesne ukonceni hry.
     * </p>
     *
     * @param p objekt hrace, ktery predmet pouziva (dojde k aktualizaci jeho znalosti)
     * @param g instance hry pro pristup k hernim datum a stavu
     */
    public String use(Player p, Game g) {
        if (id.equals("stary_svitek")) {
            p.knowsWeakness = true;
            return "Dozvěděl ses slabinu Golema.";
        }
        return "";
    }

    public Item(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    private boolean portable = true;

    public boolean isPortable() {
        return portable;
    }
}
