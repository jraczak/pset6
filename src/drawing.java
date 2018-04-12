//  Created by Justin on 4/10/18

import javax.swing.*;
import java.awt.*;

public class drawing {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("HelloWorld");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);
        jFrame.setLayout(new BorderLayout());

        //JLabel label = new JLabel("Now enter your name here!");
        //jFrame.getContentPane().add(label);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        jPanel.add(button1);
        jPanel.add(button2);
        jFrame.add(jPanel, BorderLayout.NORTH);

        JButton centerButton = new JButton("Center");
        jFrame.add(centerButton, BorderLayout.CENTER);

        JPanel southJPanel = new JPanel();
        southJPanel.setLayout(new BorderLayout());
        JButton southwestButton = new JButton("Southwest");
        JButton southeastButton = new JButton("Southeast");
        southJPanel.add(southwestButton, BorderLayout.WEST);
        southJPanel.add(southeastButton, BorderLayout.EAST);
        jFrame.add(southJPanel, BorderLayout.SOUTH);



        //JTextField textField = new JTextField();
        //jFrame.getContentPane().add(textField);

        //JOptionPane optionPane = new JOptionPane();
        //String name = JOptionPane.showInputDialog(null, "Please input your name");
//
        //jFrame.pack();
        jFrame.setVisible(true);
    }
}
