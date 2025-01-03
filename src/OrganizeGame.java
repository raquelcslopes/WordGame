import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.util.*;

public class OrganizeGame {
    private Player player = new Player();
    private ArrayList<String> threeLetterWord = new ArrayList<>();
    private ArrayList<String> fourLetterWord = new ArrayList<>();
    private ArrayList<String> fiveLetterWord = new ArrayList<>();
    private ArrayList<String> sixLetterWord = new ArrayList<>();
    private ArrayList<String> sevenLetterWord = new ArrayList<>();
    private ArrayList<String> eigthLetterWord = new ArrayList<>();
    private ArrayList<String> wrongAnswers = new ArrayList<>();
    private String gameWord;
    List<Character> wordLevelList;
    private char[] wordLevelSplitedCharArray;
    private char[] getWordLevelShuffledCharArray;
    private int joker;
    private int counter;
    private int gameLevel;

    public OrganizeGame() {
        this.joker = 10;
        this.gameLevel = 1;
    }

    public Player getPlayer() {
        return player;
    }

    public String getGameWord() {
        return gameWord;
    }

    public int getJoker() {
        return joker;
    }

    public ArrayList<String> getSevenLetterWord() {
        return sevenLetterWord;
    }

    public ArrayList<String> getEigthLetterWord() {
        return eigthLetterWord;
    }

    public void setJoker(int joker) {
        this.joker = joker;
    }

    public ArrayList<String> getThreeLetterWord() {
        return threeLetterWord;
    }

    public ArrayList<String> getFourLetterWord() {
        return fourLetterWord;
    }


    public ArrayList<String> getFiveLetterWord() {
        return fiveLetterWord;
    }


    public ArrayList<String> getSixLetterWord() {
        return sixLetterWord;
    }


    public int getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(int gameLevel) {
        this.gameLevel = gameLevel;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public ArrayList<String> getWrongAnswers() {
        return wrongAnswers;
    }

    public void start() throws Exception {
        intro();
        //backgroundMusic();

        while (getJoker() >= 0) {
            createLists();
            wordLevel();
            shuflleWordLevel();
            showShuffledWord();
            checkWord();
            increaseJoker();
            finishGame();
        }
    }

    private void intro() throws NotAnOption {
        final String BACKGROUND_MAGENTA = "\u001B[45m";
        final String RESET = "\u001B[0m";

        System.out.println(BACKGROUND_MAGENTA + " WELCOME TO THE WORD GAME " + RESET + " \n" +
                "I know, not an original name, but it is what it is, let's begin! \n" +
                "In this game you will have shuffled letters and you will have to guess the word. \n" +
                "We will start with a 3 letter word, then a 4 letter word and so on, until 8 letter word... After that you will have a trash letter between the shuffled letters. You though it would be easy han?! \n" +
                "You also have 3 jokers, so you can play a little, instead of losing on the first round. IF BY MIRACLE you guess the word in 1.2 seconds or guess 3 in a row, you will gain an extra joker.\n" +
                "Write however you want, I'm not sensitive 😉 \n" +
                "I guess it is it... Good luck Charlie! \n \n");

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Are you ready?? ✌(-‿-)✌ (Y/N)");

        String guess = myScanner.next().toLowerCase();

        if (guess.equals("y")) {
            System.out.println("Let's start!\n " +
                    "Don't forget to play ENTER");
        } else if (guess.equals("n")) {
            System.out.println("Coward...");
            setJoker(-1);
        } else {
            throw new NotAnOption();
        }
    }

    public void createLists() {
        getThreeLetterWord().add("ego");
        getThreeLetterWord().add("dor");
        getThreeLetterWord().add("ato");
        getThreeLetterWord().add("dia");
        getThreeLetterWord().add("sem");
        getThreeLetterWord().add("reu");
        getThreeLetterWord().add("ceu");
        getThreeLetterWord().add("lua");
        getThreeLetterWord().add("fim");
        getThreeLetterWord().add("pai");

        getFourLetterWord().add("brio");
        getFourLetterWord().add("mito");
        getFourLetterWord().add("saga");
        getFourLetterWord().add("ruim");
        getFourLetterWord().add("tras");
        getFourLetterWord().add("caos");
        getFourLetterWord().add("sede");
        getFourLetterWord().add("zelo");
        getFourLetterWord().add("coxo");
        getFourLetterWord().add("soar");

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

        getSixLetterWord().add("cinico");
        getSixLetterWord().add("ambito");
        getSixLetterWord().add("enfase");
        getSixLetterWord().add("hetero");
        getSixLetterWord().add("otario");
        getSixLetterWord().add("inocuo");
        getSixLetterWord().add("cetico");
        getSixLetterWord().add("nocivo");
        getSixLetterWord().add("solene");
        getSixLetterWord().add("mister");

        getSevenLetterWord().add("sublime");
        getSevenLetterWord().add("sucinto");
        getSevenLetterWord().add("empatia");
        getSevenLetterWord().add("trivial");
        getSevenLetterWord().add("sucesso");
        getSevenLetterWord().add("estigma");
        getSevenLetterWord().add("orgulho");
        getSevenLetterWord().add("trivial");
        getSevenLetterWord().add("virtude");
        getSevenLetterWord().add("apatico");

        getEigthLetterWord().add("inerente");
        getEigthLetterWord().add("peculiar");
        getEigthLetterWord().add("pandemia");
        getEigthLetterWord().add("abstrato");
        getEigthLetterWord().add("analogia");
        getEigthLetterWord().add("inospito");
        getEigthLetterWord().add("alicerce");
        getEigthLetterWord().add("monotono");
        getEigthLetterWord().add("prudente");
        getEigthLetterWord().add("invasivo");
    }

    public void wordLevel() {
        int randomIndex = (int) (Math.random() * (getThreeLetterWord().size()));

        switch (getGameLevel()) {
            case 1:
                gameWord = getThreeLetterWord().get(randomIndex);
                break;
            case 2:
                gameWord = getFourLetterWord().get(randomIndex);
                break;
            case 3:
                gameWord = getFiveLetterWord().get(randomIndex);
                break;
            case 4:
                gameWord = getSixLetterWord().get(randomIndex);
                break;
            case 5:
                gameWord = getSevenLetterWord().get(randomIndex);
                break;
            case 6, 7, 8, 9, 10:
                gameWord = getEigthLetterWord().get(randomIndex);
                break;
        }
    }

    private List<Character> convertWordLevelToList() {
        wordLevelSplitedCharArray = gameWord.toCharArray();
        List<Character> wordLevelList = new ArrayList<>();

        for (char element : wordLevelSplitedCharArray) {
            wordLevelList.add(element);
        }
        return wordLevelList;
    }

    public List<Character> shuflleWordLevel() {
        //fazer suffle
        wordLevelList = convertWordLevelToList();
        Collections.shuffle(wordLevelList);

        return wordLevelList;
    }


    public void showShuffledWord() throws Exception {
        final String BRIGHT_BACKGROUND_YELLOW = "\u001B[43;1m";
        final String RESET = "\u001B[0m";

        if (getGameLevel() < 7) {
            getWordLevelShuffledCharArray = getChars();

            //if shuffle == original word
            if (!Arrays.equals(getWordLevelShuffledCharArray, wordLevelSplitedCharArray)) {
                //print shuffled word and increasing the game level
                System.out.println(" \n----- LEVEL " + getGameLevel() + " ----- ");
                System.out.println(BRIGHT_BACKGROUND_YELLOW + Arrays.toString(getWordLevelShuffledCharArray) + RESET);
            } else {
                wordLevel();
            }
        } else {
            System.out.println(" \n----- LEVEL " + getGameLevel() + " ----- ");
            addRandomLetter(BRIGHT_BACKGROUND_YELLOW, RESET);
        }
    }

    private void wrongAnswer() throws Exception {
        final String BRIGHT_BACKGROUND_YELLOW = "\u001B[43;1m";
        final String RESET = "\u001B[0m";

        char[] wordChar = getWordLevelShuffledCharArray;

        do {
            System.out.println(BRIGHT_BACKGROUND_YELLOW + Arrays.toString(wordChar) + RESET);
        } while (!checkWord());
    }

    private void addRandomLetter(String BRIGHT_BACKGROUND_YELLOW, String RESET) {
        String abc = "abcdefghijklmnopqrstuvxz";
        List<Character> abcCharacter = new ArrayList<>();

        //create abc array
        for (int i = 0; i < abc.length(); i++) {
            abcCharacter.add(abc.charAt(i));
        }

        //add random letter and shuffle again
        int randomIndex = (int) (Math.random() * (abc.length()));
        wordLevelList.add(abcCharacter.get(randomIndex));
        Collections.shuffle(wordLevelList);

        //print the shuffled word
        System.out.println(BRIGHT_BACKGROUND_YELLOW + wordLevelList + RESET);
    }

    private char[] getChars() {
        List<Character> listCharOfChosenWord = shuflleWordLevel();

        //convert to an array
        char[] newArray = new char[listCharOfChosenWord.size()];

        for (int i = 0; i < listCharOfChosenWord.size(); i++) {
            newArray[i] = listCharOfChosenWord.get(i);
        }
        return newArray;
    }


    public boolean checkWord() throws Exception {
        final String WHITE = "\u001B[37m";
        final String RED = "\033[0;31m";
        final String RESET = "\u001B[0m";
        final String BRIGHT_GREEN = "\u001B[32;1m";

        //initialize the timer as soon as the player starts typing
        long initialTime = System.nanoTime();

        String playerGuess = getPlayer().guessTheWord().toLowerCase();

        //ends the timer count
        long endTime = System.nanoTime();

        double time = (endTime - initialTime) / 1_000_000_000.0;

        if (playerGuess.equals(getGameWord())) {
            System.out.println(WHITE + "Uhh lucky one 🫣\n" + getJoker() + " JOKER left\n" + RESET);
            rightAnswerMusic();
            setGameLevel(getGameLevel() + 1);
            setCounter(getCounter() + 1);

            if (time < 2) {
                System.out.println(BRIGHT_GREEN + " ☞ QUICK ONE, YOU WON 1 JOKER 🥳" + RESET);
                setJoker(getJoker() + 1);
            }
            return true;

        } else if (playerGuess.equals("joker")) {
            useJoker();
            System.out.println(RED + "Dummy 🫢" + RESET);

        } else if (playerGuess.equals("restart")) {
            JOptionPane.showMessageDialog(null, "Are you sure?", null,
                    JOptionPane.INFORMATION_MESSAGE);
            restart();

        } else if (getWrongAnswers().contains(playerGuess)) {
            System.out.println("You've already tried this one\n");

        } else {
            System.out.println(WHITE + "Nice try 🫠\n" + RESET);
            wrongAnswerMusic();
            getWrongAnswers().add(playerGuess);
            wrongAnswer();
        }
        return false;
    }

    public void increaseJoker() {
        final String RESET = "\u001B[0m";
        final String BRIGHT_GREEN = "\u001B[32;1m";

        if (counter == 3) {
            this.joker++;
            System.out.println(BRIGHT_GREEN + " ☞ You've won 1 JOKER 🤗" + RESET);
            setCounter(0);
        }
    }

    public void useJoker() {
        System.out.println("The answer is: " + getGameWord() + " 🤯");
        setJoker(getJoker() - 1);
        setGameLevel(getGameLevel() + 1);

        if (getJoker() >= 0) {
            System.out.println("You have " + getJoker() + "  JOKER left...");
        }

        if (getJoker() < 0) {
            System.out.println("                                                                               \n" +
                    " ,----.     ,---.  ,--.   ,--.,------.     ,-----.,--.   ,--.,------.,------.  \n" +
                    "'  .-./    /  O  \\ |   `.'   ||  .---'    '  .-.  '\\  `.'  / |  .---'|  .--. ' \n" +
                    "|  | .---.|  .-.  ||  |'.'|  ||  `--,     |  | |  | \\     /  |  `--, |  '--'.' \n" +
                    "'  '--'  ||  | |  ||  |   |  ||  `---.    '  '-'  '  \\   /   |  `---.|  |\\  \\  \n" +
                    " `------' `--' `--'`--'   `--'`------'     `-----'    `-'    `------'`--' '--' \n" +
                    "                                                                               ");
        }
    }

    public void rightAnswerMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String filePath = ("/Users/admin.mindera/IdeaProjects/Word Game/src/Assets/Correct Answer sound effect.wav");
        Music musicObj = new Music();
        musicObj.playMusic(filePath);
    }

    public void wrongAnswerMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String filePath = ("/Users/admin.mindera/IdeaProjects/Word Game/src/Assets/Wrong Answer Sound effect.wav");
        Music musicObj = new Music();
        musicObj.playMusic(filePath);
    }

    public void backgroundMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String filePath = ("/Users/admin.mindera/IdeaProjects/Word Game/src/Assets/10 minutes - Relax & study with me Lofi ｜ Space kitty #timer #10minutes   #10min #lofi.wav");
        Music musicObj = new Music();
        musicObj.playMusic(filePath);
    }

    public void restart() throws Exception {
        start();
        setJoker(3);
    }

    public void finishGame () {
        if(getGameLevel() == 11) {
            setJoker(-1);
            System.out.println(" __        _____ _   _ _   _ _____ ____  \n" +
                    " \\ \\      / /_ _| \\ | | \\ | | ____|  _ \\ \n" +
                    "  \\ \\ /\\ / / | ||  \\| |  \\| |  _| | |_) |\n" +
                    "   \\ V  V /  | || |\\  | |\\  | |___|  _ < \n" +
                    "    \\_/\\_/  |___|_| \\_|_| \\_|_____|_| \\_\\\n" +
                    "                                         ");
        }
    }
}