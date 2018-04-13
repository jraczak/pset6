//  Created by Justin on 4/12/18

import javax.swing.*;
import java.awt.*;

public class BullsEye extends JFrame {

    public BullsEye() {
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BullsEye();
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(100, 100, 250, 250);
        g.setColor(Color.WHITE);
        g.fillOval(125, 125, 200, 200);
        g.setColor(Color.BLACK);
        g.fillOval(150, 150, 150, 150);
        g.setColor(Color.WHITE);
        g.fillOval(175, 175, 100,100);
        g.setColor(Color.BLACK);
        g.fillOval(200, 200, 50, 50);
    }
}
