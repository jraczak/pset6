//  Justin Raczak
//  CSCI E-10b (24027)
//  Pset6

/*
This program mimics a basic currency converter using Java graphics. I had a lot of
trouble getting this UI to lay out properly for some reason.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Currency {


    public static void main(String[] args) {

        showCurrencyConverter();
    }

    private static void showCurrencyConverter() {

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();

        JFrame frame = new JFrame("Currency Converter");
        frame.setLayout(layout);
        frame.setSize(500, 200);

        JLabel dollarLabel = new JLabel("USD");
        JTextPane dollarField = new JTextPane();
        dollarField.setText("0.0");
        JLabel euroLabel = new JLabel("EUR");
        JTextPane euroField = new JTextPane();
        euroField.setText("0.00");

        JButton bConvertToDollars = new JButton("<");
        JButton bConvertToEuros = new JButton(">");

        bConvertToDollars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dollarField.setText(String.valueOf(Math.round(Double.parseDouble(euroField.getText())) / 1.23));
            }
        });
        bConvertToEuros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                euroField.setText(String.valueOf(Math.round(Double.parseDouble(dollarField.getText())) * 1.23));
            }
        });

        /*
        No matter how I adjusted this, I couldn't get this layout to display the way I wanted. Interestingly,
        I did not have the same problem when starting my calculator interface.
         */
        addUIComponent(constraints, layout, frame, dollarLabel, 0, 0, 5, 1);
        addUIComponent(constraints, layout, frame, euroLabel, 0, 5, 5, 1);
        addUIComponent(constraints, layout, frame, dollarField, 1, 0, 3, 1);
        addUIComponent(constraints, layout, frame, bConvertToDollars, 1, 3, 2, 1);
        addUIComponent(constraints, layout, frame, bConvertToEuros, 1, 6, 2, 1);
        addUIComponent(constraints, layout, frame, euroField, 1, 8, 3, 1);

        frame.setVisible(true);
    }

    /*
    Helper method to configure constraints and add component credited to GridBagLayoutDemo.java from class samples
     */
    private static void addUIComponent(GridBagConstraints constraints,
                                GridBagLayout layout,
                                JFrame frame,
                                Component component,
                                int row, int column, int width, int height) {
        constraints.gridx = column;
        constraints.gridy = row;

        constraints.gridwidth = width;
        constraints.gridheight = height;

        layout.setConstraints(component, constraints);
        frame.add(component);
    }
}