public class Main {
    public static void main(String[] args) throws Exception {
        final String BACKGROUND_RED = "\u001B[41m";
        final String RESET = "\u001B[0m";

        Game game = new Game();

        try {
            game.start();
        } catch (Exception e) {
            System.out.println(BACKGROUND_RED + "Something went wrong. Let's try again" + RESET);
        } finally {
            game.start();
        }
    }
}