package Game;
public class Main {
    public static Game game;


    public static void main(String[] args) {
        GameData data = GameData.loadGameDataFromResources("/game.json");
        game = new Game(data);
        game.run();
    }
}