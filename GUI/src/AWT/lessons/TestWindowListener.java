package AWT.lessons;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindowListener {
    public static void main(String[] args) {
        new WindowFrame();
    }
}

class WindowFrame extends Frame {
    public WindowFrame(){
        setBackground(Color.BLUE);
        setBounds(100,100,200,200);
        setVisible(true);
        //addWindowListener(new MyWindowListener());

        this.addWindowListener(new WindowAdapter() {
            // 匿名内部类
            //关闭窗口
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
            }
            //激活窗口
            @Override
            public void windowActivated(WindowEvent e) {
                WindowFrame source = (WindowFrame) e.getSource();
                source.setTitle("被激活了");
                System.out.println("windowActivated");
            }
        });
    }
}
