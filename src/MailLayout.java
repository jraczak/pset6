//  Justin Raczak
// CSCI E-10b (24027)
// Pset6

/*
This program mimics a very basic email GUI and with basic text fields and prints the
"sent" message to an output file called outbox.txt.
 */

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class MailLayout {
    public static void main(String[] args) {
        showComposeView();
    }

    private static void showComposeView() {

        // Create and configure the parent window
        JFrame frame = new JFrame("New Message");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0,1));

        // Create and configure a panel to hold the to, cc, bcc, subject, and from fields
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        // Create and configure a panel to hold the content field and send button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        // Create and configure a panel to hold and organize all of the labels on the left
        JPanel labelContainer = new JPanel();
        labelContainer.setLayout(new BoxLayout(labelContainer, BoxLayout.Y_AXIS));
        labelContainer.setSize(new Dimension(400, 200));
        labelContainer.setAlignmentY(Component.TOP_ALIGNMENT);

        // Create a configure a panel to hold and organize all of the text fields on the right
        JPanel fieldContainer = new JPanel();
        fieldContainer.setLayout(new BoxLayout(fieldContainer, BoxLayout.Y_AXIS));
        fieldContainer.setMaximumSize(new Dimension(400, 200));
        fieldContainer.setAlignmentY(Component.TOP_ALIGNMENT);

        // Create a set of utility dimensions to apply to each of the GUI elements
        Dimension textFieldDimension = new Dimension();
        textFieldDimension.setSize(150, 5);
        Dimension labelDimension = new Dimension();
        labelDimension.setSize(30, 40);
        Dimension labelTopSpacer = new Dimension(0, 13);
        Dimension labelBottomSpacer = new Dimension(0, 13);

        /*
        Instantiate all of the top panel text fields and related labels and add them to containers.
        This add code could be cleaned up using loops, but it was advantageous to leave the individual
        calls exposed while I'm learning how to work with these Java GUI components.

        For each field, a label and text field are created and then added to the parent container along with
        spacers to improve the appearance of the layout.
         */
        JLabel toLabel = new JLabel("To:");
        toLabel.setSize(labelDimension);
        JTextField toField = new JTextField();
        toField.setSize(textFieldDimension);
        labelContainer.add(Box.createRigidArea(labelTopSpacer));
        labelContainer.add(toLabel);
        labelContainer.add(Box.createRigidArea(labelBottomSpacer));
        fieldContainer.add(toField);

        JLabel ccLabel = new JLabel("Cc:");
        JTextField ccField = new JTextField();
        ccField.setSize(textFieldDimension);
        labelContainer.add(Box.createRigidArea(labelTopSpacer));
        labelContainer.add(ccLabel);
        labelContainer.add(Box.createRigidArea(labelBottomSpacer));
        fieldContainer.add(ccField);

        JLabel bccLabel = new JLabel("Bcc:");
        JTextField bccField = new JTextField();
        bccField.setSize(textFieldDimension);
        labelContainer.add(Box.createRigidArea(labelTopSpacer));
        labelContainer.add(bccLabel);
        labelContainer.add(Box.createRigidArea(labelBottomSpacer));
        fieldContainer.add(bccField);

        JLabel subjectLabel = new JLabel("Subject:");
        JTextField subjectField = new JTextField();
        subjectField.setSize(textFieldDimension);

        // Update the window title to match the subject line, or clear it if no subject
        subjectField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                frame.setTitle(subjectField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (subjectField.getText().length() == 0) frame.setTitle("New Message");
                else frame.setTitle(subjectField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (subjectField.getText().length() == 0) frame.setTitle("New Message");
                else frame.setTitle(subjectField.getText());
            }
        });

        labelContainer.add(Box.createRigidArea(labelTopSpacer));
        labelContainer.add(subjectLabel);
        labelContainer.add(Box.createRigidArea(labelBottomSpacer));
        fieldContainer.add(subjectField);

        JLabel fromLabel = new JLabel("From:");
        JComboBox<String> fromField = new JComboBox<>();
        // Load the combo box with email accounts
        String[] emailAccounts = {
                "Justin Raczak - jraczak@gmail.com",
                "Justin Raczak - jur376@g.harvard.edu",
                "Justin Raczak - justinraczak@thumbtack.com"};
        for (String s : emailAccounts) fromField.addItem(s);
        labelContainer.add(Box.createRigidArea(labelTopSpacer));
        labelContainer.add(fromLabel);
        labelContainer.add(Box.createRigidArea(labelBottomSpacer));
        fieldContainer.add(fromField);

        JTextArea contentField = new JTextArea();
        contentField.setMinimumSize(new Dimension(150, 100));
        JButton sendButton = new JButton("Send");

        // Wire up the button to print the email content to outbox.txt and clear all field values
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File destinationFile = new File("outbox.txt");
                try {
                    PrintStream printStream = new PrintStream(destinationFile);
                    String content = contentField.getText();
                    printStream.print(content);
                } catch (FileNotFoundException fe) {
                    System.out.println("The provided destination file was not found; skipping outbox writing.");
                }

                // Reset all of the text fields
                toField.setText("");
                ccField.setText("");
                bccField.setText("");
                subjectField.setText("");
                contentField.setText("");
                System.out.println("The user \"sent\" the message; text values cleared.");

                frame.setTitle("New Message");
            }
        });

        // Add all of the fields and labels to the panes
        topPanel.add(labelContainer);
        topPanel.add(fieldContainer);
        bottomPanel.add(contentField);
        bottomPanel.add(sendButton);

        // Add the panes to the frame and show the frame
        frame.add(topPanel);
        frame.add(bottomPanel);
        frame.setVisible(true);
    }
}
