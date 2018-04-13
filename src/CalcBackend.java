public class CalcBackend {

    private Calculator calculator;
    private String enteredCharacters;

    public CalcBackend(Calculator c) {
        this.calculator = c;
        enteredCharacters = "";
    }

    public void feedChar(char c) {
        enteredCharacters = enteredCharacters + String.valueOf(c);
    }

    public double getDisplayVal() {
        return Double.parseDouble(enteredCharacters);
    }
}
