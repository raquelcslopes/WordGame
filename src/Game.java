import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {
    private Player player;
    private ArrayList<String> threeLetterWord = new ArrayList<>();
    private ArrayList<String> fourLetterWord = new ArrayList<>();
    private ArrayList<String> fiveLetterWord = new ArrayList<>();
    private ArrayList<String> sixLetterWord = new ArrayList<>();
    private String chosenWord = chooseRandomWord();
    private int joker;//faz sentido?

    public Game (Player player) {
        this.player=player;
        this.joker = 1;
    }

    public Player getPlayer() {
        return player;
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

    public void start () {
        System.out.println(" WELCOME TO THE WORD GAME \n" +
                "I know, not an original name, but it is what it is, let's begin! \n" +
                "In this game you will have shuffled letters and you will have to guess the word. \n" +
                "We will start with a 3 letter word, then a 4 letter word and so on, until 6 letter word... After that you will have a trash letter between the shuffled letters. You though it would be easy han?! \n" +
                "You also have 1 joker, so you can play a little instead of losing in the first round. IF BY MIRACLE you guess the word in 5 seconds, you will gain a extra joker.\n" +
                "I guess it is it... Good luck Charlie! \n \n");


        //shuflleWord();
        //checkWord();

    }

    public void createLists () {
        getThreeLetterWord().add("ego");
        getThreeLetterWord().add("dor");
        getThreeLetterWord().add("ato");
        getThreeLetterWord().add("dia");
        getThreeLetterWord().add("sem");

        getFourLetterWord().add("brio");
        getFourLetterWord().add("mito");
        getFourLetterWord().add("saga");
        getFourLetterWord().add("ruim");
        getFourLetterWord().add("trás");

        getFiveLetterWord().add("exito");
        getFiveLetterWord().add("etica");
        getFiveLetterWord().add("tenue");
        getFiveLetterWord().add("cerne");
        getFiveLetterWord().add("anexo");

        getSixLetterWord().add("cinico");
        getSixLetterWord().add("ambito");
        getSixLetterWord().add("enfase");
        getSixLetterWord().add("hetero");
        getSixLetterWord().add("otario");
    }

    public String chooseRandomWord () {
        createLists();

        String choosenWord = " ";

        int min = 0;
        int max = 4;
        int randomIndex = (int) (Math.random() * (max - min) + min);

            switch (getJoker()) {
                case 1:
                    choosenWord = getThreeLetterWord().get(randomIndex);
                    break;
                case 2:
                    choosenWord = getFourLetterWord().get(randomIndex);
                    break;
                case 3:
                    choosenWord = getFiveLetterWord().get(randomIndex);
                    break;
                case 4:
                    choosenWord = getSixLetterWord().get(randomIndex);
                    break;
            }
            return choosenWord;
    }

    public void shuflleWord () {
        //converter em array de chars
        char [] splitedChosenWord = chosenWord.toCharArray();

        //converter em lista
        List<Character> listCharOfChosenWord = new ArrayList<>();
        for (char element : splitedChosenWord) {
            listCharOfChosenWord.add(element);
        }

        //fazer suffle
        Collections.shuffle(listCharOfChosenWord);

        //converter de volta a array
        for (int i =0; i< splitedChosenWord.length; i++) {
            splitedChosenWord[i] = listCharOfChosenWord.get(i);
        }

        System.out.println(Arrays.toString(splitedChosenWord));
    }

    public void checkWord () {
        getPlayer().guessTheWord();

        String playerGuess = getPlayer().guessTheWord();

        System.out.println(playerGuess.equals(chosenWord));


    }



}

