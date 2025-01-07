import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.util.Collections;

public class Wordle {
    private ArrayList<String> fiveLetterWord = new ArrayList<>();
    private Player player = new Player();
    private String gameWord;
    private char[] gameWordCharArray;
    private List<Character> gameWordCharList = new ArrayList<>();
    private int counter;
    private boolean gameOn = true;
    private String playerGuess;

    public ArrayList<String> getFiveLetterWord() {
        return fiveLetterWord;
    }

    public void setFiveLetterWord(ArrayList<String> fiveLetterWord) {
        this.fiveLetterWord = fiveLetterWord;
    }

    public Player getPlayer() {
        return player;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setGameOn(boolean gameOn) {
        this.gameOn = gameOn;
    }

    public void intro() throws Exception {
        System.out.print(Colors.BACKGROUND_GREEN.getColorCode() + " W " + Colors.RESET.getColorCode());
        System.out.print(Colors.BACKGROUND_YELLOW.getColorCode() + " O " + Colors.RESET.getColorCode());
        System.out.print(Colors.BACKGROUND_WHITE.getColorCode() + " R " + Colors.RESET.getColorCode());
        System.out.print(Colors.BACKGROUND_GREEN.getColorCode() + " D " + Colors.RESET.getColorCode());
        System.out.print(Colors.BACKGROUND_YELLOW.getColorCode() + " L " + Colors.RESET.getColorCode());
        System.out.print(Colors.BACKGROUND_WHITE.getColorCode() + " E " + Colors.RESET.getColorCode());

        System.out.println("\nWordle is a word puzzle game where players try to guess a secret five-letter word within six attempts. After each guess, the game provides feedback:\n" +
                "\n" +
                Colors.GREEN.getColorCode() + "Green:" + Colors.RESET.getColorCode() + "The letter is correct and in the right position.\n" +
                Colors.YELLOW.getColorCode() + "Yellow:" + Colors.RESET.getColorCode() + "The letter is correct but in the wrong position.\n" +
                Colors.WHITE.getColorCode() + "Gray:" + Colors.RESET.getColorCode() + "The letter is not in the word at all.");

        Scanner myScanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Are you ready?? ✌(-‿-)✌ (Y/N or type 'exit' to quit)");

            String guess = myScanner.next().toLowerCase();

            try {
                switch (guess) {
                    case "y":
                        System.out.println("Let's start!\n" +
                                "Don't forget to play ENTER");
                        validInput = true;
                        break;

                    case "n":
                        System.out.println("Coward...");
                        validInput = true;
                        break;

                    case "exit":
                        System.out.println("Goodbye! See you next time! ✌(-‿-)✌");
                        System.exit(0);
                        break;

                    default:
                        throw new InvalidInputException();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public void start() throws Exception {
        intro();
        createList();
        defineWord();
        printWhiteSpaces();

        while (getCounter() <= 6) {
            convertWordListOfChars();
            comparingWords();
            loser();
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
        gameWordCharArray = gameWord.toCharArray();

        for (char element : gameWordCharArray) {
            gameWordCharList.add(element);
        }
    }

    public void printWhiteSpaces() {
        System.out.println("\n ▊ ▊ ▊ ▊ ▊\n");
    }

    public static Map<Character, ArrayList<Integer>> hashmapFunction(String word) {
        Map<Character, ArrayList<Integer>> wordHashMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (wordHashMap.containsKey(character)) {
                wordHashMap.get(character).add(i);
            } else {
                ArrayList<Integer> positions = new ArrayList<>();
                positions.add(i);

                wordHashMap.put(character, positions);
            }
        }

        return wordHashMap;
    }

    public void comparingWords() throws Exception {
        playerGuess = getPlayer().guessTheWord();
        Map<Character, ArrayList<Integer>> gameHashMap = hashmapFunction(gameWord);
        ArrayList<Character> playerGuessArrayList = new ArrayList<>();
        ArrayList<Character> charOccurrences = new ArrayList<>();

        for (char c : playerGuess.toCharArray()) {
            playerGuessArrayList.add(c);
        }

        numberOfLettersException();

        if (playerGuess.equals(gameWord)) {
            rightAnswerMusic();
            winner();
        }

        if (playerGuess.equals("restart")) {
            JOptionPane.showMessageDialog(null, "Are you sure?", null,
                    JOptionPane.INFORMATION_MESSAGE);
            restart();
        }

        coloringChars(playerGuessArrayList, gameHashMap, charOccurrences);
        counter++;
    }

    private void numberOfLettersException() throws Exception {
        try {
            if (playerGuess.length() != 5) {
                throw new NumberOfLettersWrongException();
            }
        } catch (NumberOfLettersWrongException e) {
            System.out.println(e.getMessage());
        }
    }


    private void coloringChars(ArrayList<Character> playerGuessArrayList, Map<Character, ArrayList<Integer>> gameHashMap, ArrayList<Character> charOccurrences) {
        for (int i = 0; i < playerGuess.length(); i++) {
            Character currentKey = playerGuessArrayList.get(i);

            if (gameHashMap.get(currentKey) != null) {
                charOccurrences.add(currentKey);
                boolean canOccur = Collections.frequency(charOccurrences, currentKey) <= gameHashMap.get(currentKey).size();


                if (gameHashMap.containsKey(playerGuessArrayList.get(i)) && gameHashMap.get(currentKey).contains(i)) {
                    System.out.print(Colors.BACKGROUND_GREEN.getColorCode() + currentKey + Colors.RESET.getColorCode());

                } else if (gameHashMap.containsKey(playerGuessArrayList.get(i)) && canOccur && !gameHashMap.get(currentKey).contains(i)) {
                    System.out.print(Colors.BACKGROUND_YELLOW.getColorCode() + currentKey + Colors.RESET.getColorCode());

                } else {
                    System.out.print(Colors.BACKGROUND_WHITE.getColorCode() + currentKey + Colors.RESET.getColorCode());
                }
            } else {
                System.out.print(Colors.BACKGROUND_WHITE.getColorCode() + currentKey + Colors.RESET.getColorCode());
            }
        }
        System.out.println("\n");
    }

    public void rightAnswerMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String filePath = ("/Users/admin.mindera/IdeaProjects/Word Game/src/Assets/Correct Answer sound effect.wav");
        Music musicObj = new Music();
        musicObj.playMusic(filePath);
    }

    public void gameOverMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String filePath = ("/Users/admin.mindera/IdeaProjects/Word Game/src/Assets/Game Over Sounds effect.wav");
        Music musicObj = new Music();
        musicObj.playMusic(filePath);
    }

    public void winner() {
        System.out.println(" __        _____ _   _ _   _ _____ ____  \n" +
                " \\ \\      / /_ _| \\ | | \\ | | ____|  _ \\ \n" +
                "  \\ \\ /\\ / / | ||  \\| |  \\| |  _| | |_) |\n" +
                "   \\ V  V /  | || |\\  | |\\  | |___|  _ < \n" +
                "    \\_/\\_/  |___|_| \\_|_| \\_|_____|_| \\_\\\n" +
                "                                         ");

        setCounter(7);
        setGameOn(false);

    }

    public void loser() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (getCounter() == 7) {
            setGameOn(false);
            gameOverMusic();
            System.out.println("   ___       .    __   __ .____         ___   __    __ .____  .___ \n" +
                    " .'   \\     /|    |    |  /           .'   `. |     |  /      /   \\\n" +
                    " |         /  \\   |\\  /|  |__.        |     |  \\    /  |__.   |__-'\n" +
                    " |    _   /---'\\  | \\/ |  |           |     |   \\  /   |      |  \\ \n" +
                    "  `.___|,'      \\ /    /  /----/       `.__.'    \\/    /----/ /   \\");
        }
    }

    public void restart() throws Exception {
        start();
        setCounter(0);
    }
}