import java.util.*;

public class Game {
    private Player player;
    private ArrayList<String> threeLetterWord = new ArrayList<>();
    private ArrayList<String> fourLetterWord = new ArrayList<>();
    private ArrayList<String> fiveLetterWord = new ArrayList<>();
    private ArrayList<String> sixLetterWord = new ArrayList<>();
    private String gameWord = chooseRandomWord();
    private int joker;
    private int gameLevel;

    public Game(Player player) {
        this.player = player;
        this.joker = 1;
        this.gameLevel = 1;
    }

    public Player getPlayer() {
        return player;
    }

    public String getGameWord() {
        return gameWord;
    }

    public void setGameWord(String gameWord) {
        this.gameWord = gameWord;
    }

    public int getJoker() {
        return joker;
    }

    public void setJoker(int joker) {
        this.joker = joker;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<String> getThreeLetterWord() {
        return threeLetterWord;
    }

    public void setThreeLetterWord(ArrayList<String> threeLetterWord) {
        this.threeLetterWord = threeLetterWord;
    }

    public ArrayList<String> getFourLetterWord() {
        return fourLetterWord;
    }

    public void setFourLetterWord(ArrayList<String> fourLetterWord) {
        this.fourLetterWord = fourLetterWord;
    }

    public ArrayList<String> getFiveLetterWord() {
        return fiveLetterWord;
    }

    public void setFiveLetterWord(ArrayList<String> fiveLetterWord) {
        this.fiveLetterWord = fiveLetterWord;
    }

    public ArrayList<String> getSixLetterWord() {
        return sixLetterWord;
    }

    public void setSixLetterWord(ArrayList<String> sixLetterWord) {
        this.sixLetterWord = sixLetterWord;
    }

    public int getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(int gameLevel) {
        this.gameLevel = gameLevel;
    }

    public void start() {
        intro();

        while (getJoker() != 0) {
            createLists();
            chooseRandomWord();
            shuflleWord();
            showShuffledWord();
            checkWord();
           // increaseJoker();
        }
    }

    private boolean intro() {
        final String BACKGROUND_MAGENTA = "\u001B[45m";
        final String RESET = "\u001B[0m";

        System.out.println(BACKGROUND_MAGENTA + " WELCOME TO THE WORD GAME " + RESET + " \n" +
                "I know, not an original name, but it is what it is, let's begin! \n" +
                "In this game you will have shuffled letters and you will have to guess the word. \n" +
                "We will start with a 3 letter word, then a 4 letter word and so on, until 6 letter word... After that you will have a trash letter between the shuffled letters. You though it would be easy han?! \n" +
                "You also have 1 joker, so you can play a little, instead of losing on the first round. IF BY MIRACLE you guess the word in 5 seconds or guess 3 in a row, you will gain an extra joker.\n" +
                "Write however you want, I'm not sensitive 😉 \n" +
                "I guess it is it... Good luck Charlie! \n \n");

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Are you ready?? (Y/N)");

        String guess = myScanner.next().toLowerCase();

        try {
            if (guess.equals("y")) {
                return true;
            } else if (guess.equals("n")) {
                System.out.println("Pussy");
                setJoker(0);
                return false;
            } else {
                throw new NotAnOption();
            }
        } catch (NotAnOption e) {
            throw new RuntimeException(e);
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
        getFourLetterWord().add("trás");
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
    }

    public String chooseRandomWord() {
        int min = 0;
        int max = 9;
        int randomIndex = (int) (Math.random() * (max - min) + min);

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
        }
        return gameWord;
    }

    public List<Character> shuflleWord() {
        //converter em array de chars
        char[] splitedChosenWord = gameWord.toCharArray();

        //converter em lista
        List<Character> listCharOfChosenWord = new ArrayList<>();
        for (char element : splitedChosenWord) {
            listCharOfChosenWord.add(element);
        }

        //fazer suffle
        Collections.shuffle(listCharOfChosenWord);

        return listCharOfChosenWord;
    }

        public void showShuffledWord () {
            final String BRIGHT_BACKGROUND_YELLOW = "\u001B[43;1m";
            final String RESET = "\u001B[0m";

            char[] splitedChosenWord = gameWord.toCharArray();
            List<Character> listCharOfChosenWord = shuflleWord();

            //converter de volta a array
            char[] newArray = new char[listCharOfChosenWord.size()];

            for (int i = 0; i < listCharOfChosenWord.size(); i++) {
                newArray[i] = listCharOfChosenWord.get(i);
            }

            //se aleatorio = normal
            if (Arrays.equals(newArray, splitedChosenWord)) {
                start();
            } else {
                System.out.println(BRIGHT_BACKGROUND_YELLOW + Arrays.toString(newArray) + RESET);
            }
        }

    public boolean checkWord() {
        final String WHITE = "\u001B[37m";
        final String RED = "\033[0;31m";
        final String RESET = "\u001B[0m";

        String playerGuess = getPlayer().guessTheWord().toLowerCase();

        if (playerGuess.equals(getGameWord())) {
            System.out.println(WHITE + "Uhh lucky bastard\n1 JOKER left" + RESET);
            gameLevel++;
            return true;
        } else if(playerGuess.equals("joker")) {
            useJoker();
            System.out.println(RED + "Dumb ass" + RESET);
        } else {
            System.out.println(WHITE + "Nice try bitch" + RESET);
        }
        return false;
    }

    public void increaseJoker () { //ERROR
        int counter = 0;

        if(checkWord()) {
            counter += 1;
        }

        if(counter == 3) {
            this.joker ++;
        }
    }

    public void useJoker () {
        System.out.println("The answer is: " + getGameWord());
        this.joker--;
        System.out.println("You have " + getJoker() + " left...");
    }
}

