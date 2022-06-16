package Swing.lessons;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SelectionDemo extends JFrame {
    public SelectionDemo() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(2,2,10,10));

        JPanel jPanel1 = new JPanel(new GridLayout(3, 1));
        JPanel jPanel2 = new JPanel(new GridLayout(1, 2));

        //将图片变成图标
        URL path = JButtonDemo.class.getResource("../img/1.jpeg");
        ImageIcon icon = new ImageIcon(path);

        // 单选框：需要分组
        JRadioButton jRadioButton1 = new JRadioButton("单选1");
        JRadioButton jRadioButton2 = new JRadioButton("单选2");
        JRadioButton jRadioButton3 = new JRadioButton("单选3");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);

        //多选框
        JCheckBox jCheckBox1 = new JCheckBox("多选1");
        JCheckBox jCheckBox2 = new JCheckBox("多选2");

        jPanel1.add(jRadioButton1, BorderLayout.NORTH);
        jPanel1.add(jRadioButton2, BorderLayout.CENTER);
        jPanel1.add(jRadioButton3, BorderLayout.SOUTH);
        jPanel2.add(jCheckBox1, BorderLayout.EAST);
        jPanel2.add(jCheckBox2, BorderLayout.WEST);
        pane.add(jPanel1);
        pane.add(jPanel2);

        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SelectionDemo();
    }
}
