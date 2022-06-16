package Swing.lessons;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconDemo extends JFrame {
    public ImageIconDemo() {
        //获取图片地址
        JLabel jLabel = new JLabel("ImageIcon");
        URL url = ImageIconDemo.class.getResource("../img/1.jpeg");
        System.out.println(url);

        ImageIcon imageIcon = new ImageIcon(url);
        jLabel.setIcon(imageIcon);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Container pane = getContentPane();
        pane.add(jLabel);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ImageIconDemo();
    }
}
