package Swing.lessons;

import javax.swing.*;
import java.awt.*;

public class ComboBoxDemo extends JFrame {
    public ComboBoxDemo() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(1,2,10,10));
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();

        // 下拉框
        JComboBox box = new JComboBox();
        box.addItem("1");
        box.addItem("2");
        box.addItem("3");
        box.addItem("4");
        jPanel1.add(box);

        //列表框
        String[] content = {"1" , "2", "3"};
        JList jList = new JList(content);
        jPanel2.add(jList);

        pane.add(jPanel1);
        pane.add(jPanel2);

        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ComboBoxDemo();
    }
}
