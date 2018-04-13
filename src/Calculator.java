// Justin Raczak
// CSCI E-10b (24027)
// Pset6

/*
This program functions as a basic calculator similar to those found on Windows and Mac
computers. THIS PROGRAM IS INCOMPLETE.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame{

    private CalcBackend calcBackend;
    private JFrame frame;
    private GridBagLayout layout;
    private GridBagConstraints constraints;

    public Calculator() {
        frame = new JFrame("Calculator");
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        calcBackend = new CalcBackend(this);

        frame.setSize(500, 600);
        frame.setLayout(layout);

        JTextField screen = new JTextField();
        screen.setText("0");
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setEditable(false);
        screen.setBackground(Color.BLACK);
        screen.setForeground(Color.CYAN);

        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b6 = new JButton("6");
        JButton b5 = new JButton("5");
        JButton b4 = new JButton("4");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b0 = new JButton("0");
        JButton bPeriod = new JButton(".");
        JButton bClear = new JButton("C");
        JButton bSquareRoot = new JButton("\u221A");
        JButton bDivide = new JButton("/");
        JButton bMultiply = new JButton("*");
        JButton bSubtract = new JButton("-");
        JButton bAdd = new JButton("+");
        JButton bEquals = new JButton("=");

        //TODO: Set button listener assignment programmatically
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcBackend.feedChar(b5.getText().charAt(0));
                screen.setText(String.valueOf(calcBackend.getDisplayVal()));
            }
        });

        constraints.fill = GridBagConstraints.BOTH;
        addUIComponent(screen, 0, 0, 4, 2);

        addUIComponent(bClear, 2, 0, 1, 1);
        addUIComponent(bSquareRoot, 2, 1, 1, 1);
        addUIComponent(bDivide, 2, 2, 1, 1);
        addUIComponent(bMultiply, 2, 3, 1, 1);
        addUIComponent(bSubtract, 3, 3, 1, 1);
        addUIComponent(bAdd, 4, 3, 1, 1);
        addUIComponent(bEquals, 5, 3, 1, 2);
        addUIComponent(b7, 3, 0, 1, 1);
        addUIComponent(b8, 3, 1, 1, 1);
        addUIComponent(b9, 3, 2, 1, 1);
        addUIComponent(b6, 4, 0, 1, 1);
        addUIComponent(b4, 4, 1, 1, 1);
        addUIComponent(b5, 4, 2, 1, 1);
        addUIComponent(b1, 5, 0, 1, 1);
        addUIComponent(b2, 5, 1, 1, 1);
        addUIComponent(b3, 5, 2, 1, 1);
        addUIComponent(b0, 6, 0, 2, 1);
        addUIComponent(bPeriod, 6, 2, 1, 1);


        frame.setVisible(true);
    }

    /*
    Helper method to configure constraints and add component credited to GridBagLayoutDemo.java from class samples
     */
    private void addUIComponent(Component component,
                                int row, int column, int width, int height) {
        constraints.gridx = column;
        constraints.gridy = row;

        constraints.gridwidth = width;
        constraints.gridheight = height;

        layout.setConstraints(component, constraints);
        frame.add(component);
    }

    // Register for operator keys to store the current value in the screen when pressed, before moving on to calculate
    // and collect more input

    //TODO: Display ERROR message if sq root is attempted on a negative number

    public static void main(String[] args) {
        //TODO: create an instance of the app and make sure things show up
        Calculator calculatorApp = new Calculator();
        calculatorApp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}


