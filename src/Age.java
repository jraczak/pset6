// Justin Raczak
// CSCI E-10b (24027)
// Pset6

/*
This program demonstrates simple use of Java GUI elements by responding to a user's age
 */
import javax.swing.*;

public class Age {
    public static void main(String[] args) {
        getUserAge();
    }

    /*
    A simple method to collect the user's age and compliment their youth or
    tease them for their more mature age.
     */
    private static void getUserAge() {
        String response;
        int age = Integer.parseInt(JOptionPane.showInputDialog("Howdy! Please tell us your age."));
        // Set the message string based on the user's provided age
        if (age < 40) response = "Well ain't youth a beautiful thing ;)";
        else response = "Hoo, boy! You're basically a dinosaur!";
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), response);
    }
}
