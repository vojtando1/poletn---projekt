package Game;
/**
 * Třída reprezentující herní postavu.
 * <p>
 * Každá postava má své unikátní ID,
 * zobrazované jméno a dialog,
 * který se vypíše při komunikaci s hráčem.
 * </p>
 *
 * @author Vojta
 */
public class GameCharacter {
    public String id;
    private String name;
    public String dialogue;

    public GameCharacter(String id, String name, String dialogue) {
        this.id = id;
        this.name = name;
        this.dialogue = dialogue;
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

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }
}
