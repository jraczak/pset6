// Justin Raczak
// CSCI E-10b (24027)
// Pset6

/*
This is the backend code accompanying Calculator.java, which mimics the functionality
of a desktop calculator.
 */

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
