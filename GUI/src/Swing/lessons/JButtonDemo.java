package Swing.lessons;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo extends JFrame {
    public JButtonDemo() {
        Container pane = getContentPane();

        //将图片变成图标
        URL path = JButtonDemo.class.getResource("../img/1.jpeg");
        ImageIcon icon = new ImageIcon(path);

        //将图片放置按钮上
        JButton jButton = new JButton();
        jButton.setIcon(icon);
        jButton.setToolTipText("图标按钮");

        pane.add(jButton);

        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonDemo();
    }
}
