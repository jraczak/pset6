// Justin Raczak
// CSCI E-10b (24027)
// Pset6

/*
This program attempts to draw the olympic rings programmatically using Java graphics.
THIS PROGRAM IS INCOMPLETE.
 */

import javax.swing.*;
import java.awt.*;

public class Olympics {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Ring Canvas");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setBackground(Color.WHITE);

        Color[] ringColors = {Color.BLUE, Color.BLACK, Color.RED, Color.YELLOW, Color.GREEN};
        // loop to call drawRing
        // need a mechanism to change lines
        // need to add to move the circles
        // i < 5, some computation to draw all the rings
        //TODO: Figure out how to interlace the rings
        drawRing(frame, Color.BLUE, 200, 100, 150);
        frame.setVisible(true);
    }

    private static void drawRing(JFrame frame,
                                 Color color,
                                 int x, int y, int radius) {

        JPanel outerRingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setColor(color);
                graphics2D.fillOval(x, y, radius, radius);

                //TODO: Figure out the relationship programmatically
                graphics2D.setColor(Color.WHITE);
                graphics2D.fillOval(x+15, y+15, 120, 120);
            }
        };

        frame.add(outerRingPanel);

    }
}
