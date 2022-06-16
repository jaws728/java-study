package Swing.lessons;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo {
    public static void main(String[] args) {
        //建立一个窗口
        new MyJFrame("JFrame测试").init();
    }
}

class MyJFrame extends JFrame {
    public MyJFrame(String title) {
        super(title);
    }

    //初始化
    public void init() {
        setBounds(100,100,200,200);
        setVisible(true);

        Container container = this.getContentPane();
        container.setBackground(Color.YELLOW);

        //设置文字：label
        JLabel jLabel = new JLabel("JLabel系列");
        add(jLabel);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //关闭事件
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
