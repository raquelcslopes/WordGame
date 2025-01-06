import java.util.Scanner;

public class WordGame {
    private Menu menu = new Menu();
    private OrganizeGame organizeGame = new OrganizeGame();
    private Wordle wordle = new Wordle();

    public WordGame() throws Exception {
    }

    public Menu getMenu() {
        return menu;
    }

    public OrganizeGame getWordGame() {
        return organizeGame;
    }

    public Wordle getWordle() {
        return wordle;
    }

    public void start() throws Exception {
        String playerChoice = getMenu().menuChoice();

        try {
            if (!playerChoice.matches("\\d")) {
                throw new InvalidInputException();
            }

            switch (playerChoice) {
                case "1":
                    getWordGame().start();
                    break;
                case "2":
                    getWordle().start();
                    break;
                case "3":
                    System.out.println("It's pretty easy buddy, just choose the game you want to play. \n" +
                            Colors.BOLD.getColorCode() + "Option 1: " + Colors.RESET.getColorCode() + "You play a game with shuffled letters; \n" +
                            Colors.BOLD.getColorCode() + "Option 2: " + Colors.RESET.getColorCode() + "You play a game where you have to guess the word;");
                    break;
                default:
                    throw new InvalidInputException();
            }
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } finally {
            start();
        }
    }
}
