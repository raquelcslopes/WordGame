public class NotAnOption extends Exception {
    public NotAnOption() {
        super(Colors.RED.getColorCode() + "Think before you write 🫠\n" + Colors.RESET.getColorCode());
    }
}
