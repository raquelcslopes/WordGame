import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wordle {
    private ArrayList<String> fiveLetterWord = new ArrayList<>();
    private Player player = new Player();
    private String gameWord;
    private char[] gameWordCharArray;
    private List<Character> gameWordCharList = new ArrayList<>();
    private int counter;
    private boolean gameOn = true;

    public Wordle() {
    }

    public ArrayList<String> getFiveLetterWord() {
        return fiveLetterWord;
    }

    public void setFiveLetterWord(ArrayList<String> fiveLetterWord) {
        this.fiveLetterWord = fiveLetterWord;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean isGameOn() {
        return gameOn;
    }

    public void setGameOn(boolean gameOn) {
        this.gameOn = gameOn;
    }

    public void intro() throws NotAnOption {
        final String RESET = "\u001B[0m";
        final String BACKGROUND_GREEN = "\u001B[42m";
        final String BACKGROUND_YELLOW = "\u001B[43m";
        final String BACKGROUND_WHITE = "\u001B[47m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String WHITE = "\u001B[37m";

        System.out.print(BACKGROUND_GREEN + " W " + RESET);
        System.out.print(BACKGROUND_YELLOW + " O " + RESET);
        System.out.print(BACKGROUND_WHITE + " R " + RESET);
        System.out.print(BACKGROUND_GREEN + " D " + RESET);
        System.out.print(BACKGROUND_YELLOW + " L " + RESET);
        System.out.print(BACKGROUND_WHITE + " E " + RESET);

        System.out.println("\nWordle is a word puzzle game where players try to guess a secret five-letter word within six attempts. After each guess, the game provides feedback:\n" +
                "\n" +
                GREEN + "Green:" + RESET + "The letter is correct and in the right position.\n" +
                YELLOW + "Yellow:" + RESET + "The letter is correct but in the wrong position.\n" +
                WHITE + "Gray:" + RESET + "The letter is not in the word at all.");

        Scanner myScanner = new Scanner(System.in);
        System.out.println("\nAre you ready?? ✌(-‿-)✌ (Y/N)");

        String guess = myScanner.next().toLowerCase();

        if (guess.equals("y")) {
            System.out.println("Let's start!\n " +
                    "Don't forget to play ENTER\n");
        } else if (guess.equals("n")) {
            System.out.println("Coward...");
        } else {
            throw new NotAnOption();
        }
    }


    public void start() throws NotAnOption, FewLetters {
        intro();

        while (getCounter() <= 6) {
            createList();
            defineWord();

            while (gameOn) {
                convertWordListOfChars();
                compareWords();
                loser();
            }
        }
    }

    public void createList() {
        getFiveLetterWord().add("exito");
        getFiveLetterWord().add("etica");
        getFiveLetterWord().add("tenue");
        getFiveLetterWord().add("cerne");
        getFiveLetterWord().add("anexo");
        getFiveLetterWord().add("nobre");
        getFiveLetterWord().add("negro");
        getFiveLetterWord().add("audaz");
        getFiveLetterWord().add("porem");
        getFiveLetterWord().add("futil");
    }

    public String selectRandomWord() {

        int randomIndex = (int) (Math.random() * (getFiveLetterWord().size()));

        return getFiveLetterWord().get(randomIndex);
    }

    public void defineWord() {
        gameWord = selectRandomWord();

    }

    public void convertWordListOfChars() {
        System.out.println("This is the game word " + gameWord);


        gameWordCharArray = gameWord.toCharArray();

        for (char element : gameWordCharArray) {
            gameWordCharList.add(element);
        }
    }


    public void compareWords() throws FewLetters {
        final String BACKGROUND_GREEN = "\u001B[42m";
        final String BACKGROUND_YELLOW = "\u001B[43m";
        final String BACKGROUND_WHITE = "\u001B[47m";
        final String RESET = "\u001B[0m";

        String playerGuess = getPlayer().guessTheWord().toLowerCase();

        char[] playerGuessCharArray = playerGuess.toCharArray();
        List<Character> playerGuessCharList = new ArrayList<>();

        for (char element : playerGuessCharArray) {
            playerGuessCharList.add(element);
        }

        fewLettersException(playerGuessCharList);

        if (playerGuess.equals(gameWord)) {
            winner();
            setCounter(7);
        } else {

            for (int i = 0; i < playerGuessCharList.size(); i++) {
                if (playerGuessCharList.get(i).equals(gameWordCharList.get(i))) {
                    System.out.print(BACKGROUND_GREEN + playerGuessCharList.get(i) + RESET);
                } else if (gameWordCharList.contains(playerGuessCharList.get(i))) {
                    System.out.print(BACKGROUND_YELLOW + playerGuessCharList.get(i) + RESET);
                } else {
                    System.out.print(BACKGROUND_WHITE + playerGuessCharList.get(i) + RESET);
                }
            }
            setCounter(getCounter() + 1);
        }
    }

    private static void fewLettersException(List<Character> playerGuessCharList) throws FewLetters {
        if(playerGuessCharList.size()<5) {
            throw new FewLetters();
        }
    }

    public void winner() {
        System.out.println(" __        _____ _   _ _   _ _____ ____  \n" +
                " \\ \\      / /_ _| \\ | | \\ | | ____|  _ \\ \n" +
                "  \\ \\ /\\ / / | ||  \\| |  \\| |  _| | |_) |\n" +
                "   \\ V  V /  | || |\\  | |\\  | |___|  _ < \n" +
                "    \\_/\\_/  |___|_| \\_|_| \\_|_____|_| \\_\\\n" +
                "                                         ");
    }

    public void loser() {
        if (getCounter() == 7) {
            setGameOn(false);
            System.out.println("   ___       .    __   __ .____         ___   __    __ .____  .___ \n" +
                    " .'   \\     /|    |    |  /           .'   `. |     |  /      /   \\\n" +
                    " |         /  \\   |\\  /|  |__.        |     |  \\    /  |__.   |__-'\n" +
                    " |    _   /---'\\  | \\/ |  |           |     |   \\  /   |      |  \\ \n" +
                    "  `.___|,'      \\ /    /  /----/       `.__.'    \\/    /----/ /   \\");
        }
    }
}
