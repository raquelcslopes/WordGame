import java.util.Scanner;

public class Menu {

    public Menu () {
    }

    public int menuChoice () {
        Scanner myScanner = new Scanner(System.in);

        System.out.println(
                "\n" +
                "╔═══╦═════════════════════════════════════╗\n" +
                "║   ║                MENU                 ║    \n" +
                "╠═══╬═════════════════════════════════════╣\n" +
                "║ 1 ║ Organize Game                       ║ \n" +
                "║ 2 ║ Wordle                              ║\n" +
                "║ 3 ║ Help                                ║ \n" +
                "╚═══╩═════════════════════════════════════╝\n" +
                "\n" +
                        "Choose your sentence:");

       return myScanner.nextInt();
    }
}
