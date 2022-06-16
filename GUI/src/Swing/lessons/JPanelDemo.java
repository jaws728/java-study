package Swing.lessons;

import javax.swing.*;
import java.awt.*;

public class JPanelDemo extends JFrame {
    public JPanelDemo(){
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(2,2,10,10));

        JPanel jPanel1 = new JPanel(new GridLayout(1,2));
        JPanel jPanel2 = new JPanel(new GridLayout(2,2));
        JPanel jPanel3 = new JPanel(new GridLayout(1,1));
        JPanel jPanel4 = new JPanel(new GridLayout(2,1));

        jPanel1.add(new JButton("1"));
        jPanel1.add(new JButton("1"));
        jPanel2.add(new JButton("2"));
        jPanel2.add(new JButton("2"));
        jPanel2.add(new JButton("2"));
        jPanel2.add(new JButton("2"));
        jPanel3.add(new JButton("3"));
        jPanel4.add(new JButton("4"));
        jPanel4.add(new JButton("4"));

        pane.add(jPanel1);
        pane.add(jPanel2);
        pane.add(jPanel3);
        pane.add(jPanel4);

        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JPanelDemo();
    }
}
