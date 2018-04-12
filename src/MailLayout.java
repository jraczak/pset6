//  Created by Justin on 4/11/18

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MailLayout {
    public static void main(String[] args) {
        showComposeView();
    }

    private static void showComposeView() {
        JFrame frame = new JFrame("New Message");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(5, 2));

        JPanel toContainer = new JPanel();
        toContainer.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

        Dimension textFieldDimension = new Dimension();
        textFieldDimension.setSize(150, 20);
        Dimension labelDimension = new Dimension();
        labelDimension.setSize(30, 20);

        // Instantiate all of the top panel text fields and related labels
        JLabel toLabel = new JLabel("To:");
        toLabel.setSize(labelDimension);
        JTextField toField = new JTextField();
        toField.setSize(textFieldDimension);
        toContainer.add(toLabel);
        toContainer.add(toField);

        JLabel ccLabel = new JLabel("Cc:");
        JTextField ccField = new JTextField();
        ccField.setSize(textFieldDimension);

        JLabel bccLabel = new JLabel("Bcc:");
        JTextField bccField = new JTextField();
        bccField.setSize(textFieldDimension);

        JLabel subjectLabel = new JLabel("Subject:");
        JTextField subjectField = new JTextField();
        subjectField.setSize(textFieldDimension);

        JLabel fromLabel = new JLabel("From:");
        JComboBox<String> fromField = new JComboBox<>();

        // Load the combo box with email accounts
        String[] emailAccounts = {
                "Justin Raczak - jraczak@gmail.com",
                "Justin Raczak - jur376@g.harvard.edu",
                "Justin Raczak - justinraczak@thumbtack.com"};
        for (String s : emailAccounts) fromField.addItem(s);

        // Add all of the fields to the top pane
        //topPanel.add(toLabel);
        topPanel.add(toContainer);
        topPanel.add(toField);
        topPanel.add(ccLabel);
        topPanel.add(ccField);
        topPanel.add(bccLabel);
        topPanel.add(bccField);
        topPanel.add(subjectLabel);
        topPanel.add(subjectField);
        topPanel.add(fromLabel);
        topPanel.add(fromField);

        frame.add(topPanel);
        frame.setVisible(true);
    }
}
