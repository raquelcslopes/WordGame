public enum Colors {
    RED ("\u001B[31m"),
    RESET ("\u001B[0m"),
    BOLD ("\u001B[1m"),
    MAGENTA ("\u001B[45m"),
    BACKGROUND_YELLOW ("\u001B[43;1m"),
    WHITE ("\u001B[37m"),
    GREEN ("\u001B[32;1m"),
    BACKGROUND_GREEN ("\u001B[42m"),
    BACKGROUND_WHITE ("\u001B[47m"),
    YELLOW ("\u001B[33m");



    private final String colorCode;

    private Colors (String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorCode() {
        return colorCode;
    }
}
