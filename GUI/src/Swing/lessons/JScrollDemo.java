package Swing.lessons;

import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame {
    public JScrollDemo() {
        Container pane = getContentPane();

        JTextArea jTextArea = new JTextArea(20, 50);
        jTextArea.setText("JTextArea...");

        //Scroll面板
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        pane.add(jScrollPane);

        setVisible(true);
        setBounds(100,100,300,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
