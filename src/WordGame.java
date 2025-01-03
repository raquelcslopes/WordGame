public class WordGame {
    private Menu menu = new Menu();
    private OrganizeGame organizeGame = new OrganizeGame();
    private Wordle wordle = new Wordle();

    public WordGame() {
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
