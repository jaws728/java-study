package AWT.lessons;

import java.awt.*;

public class DemoFrame {
    public static void main(String[] args) {
        // Frame：JDK
        Frame frame = new Frame("The first frame");

        // Set weight,height, and x,y locations
        frame.setBounds(100, 100, 200, 200);
        // OR
        // frame.setLocation(100, 100);
        // frame.setSize(200, 200);

        // Background
        frame.setBackground(new Color(230,230,230));

        // Set visible
        frame.setVisible(true);

        // Cannot be resizable
        frame.setResizable(false);
    }
}
