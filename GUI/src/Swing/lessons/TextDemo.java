package Swing.lessons;

import javax.swing.*;
import java.awt.*;

public class TextDemo extends JFrame{
    public TextDemo() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(3,1,10,10));
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();

        //文本框
        JTextField field1 = new JTextField("Hello");
        JTextField field2 = new JTextField("World", 20);
        jPanel1.add(field1);
        jPanel1.add(field2);

        //密码框
        JPasswordField pass = new JPasswordField(10);
        pass.setEchoChar('*');
        jPanel2.add(pass);

        //文本域
        JTextArea area = new JTextArea("Here is a text area");
        jPanel3.add(area);

        pane.add(jPanel1);
        pane.add(jPanel2);
        pane.add(jPanel3);

        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TextDemo();
    }
}
