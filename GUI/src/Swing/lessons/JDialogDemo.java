package Swing.lessons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogDemo extends JFrame {
    public JDialogDemo() {
        this.setVisible(true);
        this.setSize(700,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //容器
        Container c = this.getContentPane();
        //绝对布局
        c.setLayout(null);

        //按钮
        JButton jButton = new JButton("点击弹出对话框");
        jButton.setBounds(30,30,200,50);

        c.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹窗
                new MyJDialog();
            }
        });

    }

    public static void main(String[] args) {
        new JDialogDemo();
    }
}

class MyJDialog extends JDialog{
    public MyJDialog() {
        this.setVisible(true);
        this.setBounds(100,100,500,250);

        Container container = this.getContentPane();
        container.setLayout(null);
        container.add(new Label("HELLOOOOOO"));
    }
}
