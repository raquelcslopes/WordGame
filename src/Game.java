public class Game {
    private Menu menu = new Menu();
    private WordGame wordGame = new WordGame();
    private Wordle wordle = new Wordle();

    public Game () {
    }

    public Menu getMenu() {
        return menu;
    }

    public WordGame getWordGame() {
        return wordGame;
    }

    public Wordle getWordle() {
        return wordle;
    }

    public void start () throws Exception {
       int playerChoice = getMenu().menuChoice();

        switch (playerChoice) {
            case 1:
                getWordGame().start();
                break;
            case 2:
                getWordle().start();
                break;
            case 3:
                System.out.println("It's pretty easy buddy, just choose the game you want to play. \n" +
                        "Option 1: You play a game with shuffled letters; \n" +
                        "Option 2: You play a game where you have to guess the word;");
                break;
            default:
                throw new NotAnOption();
        }
    }

}
