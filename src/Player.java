import java.util.Scanner;

public class Player {
    private int points;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String guessTheWord() {
        Scanner myScanner = new Scanner(System.in);
        return myScanner.next();
    }

    public void sumPoints (int points) {
        setPoints(getPoints() + points);
    }
}
