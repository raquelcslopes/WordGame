public class InvalidInputException extends Exception {
    public InvalidInputException() {
        super(Colors.RED.getColorCode() + "Think before you write 🫠\n" + Colors.RESET.getColorCode());
    }
}
