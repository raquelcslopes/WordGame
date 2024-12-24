public class Main {
    public static void main(String[] args) throws Exception {

        Player player = new Player("Ana");

        Game game = new Game(player);

        try {
            game.start();
        } catch (Exception e) {
            System.out.println("Something went wrong.\n");
        } finally {
            game.start();
        }
    }
}