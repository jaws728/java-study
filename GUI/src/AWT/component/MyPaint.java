package AWT.component;

import java.awt.*;

public class MyPaint extends Frame {
    public void loadFrame() {
        setBounds(200,200,600,400);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        // 画笔：需要颜色，可画画
        g.setColor(Color.red);
        //g.drawOval(100,100,100,100);
        g.fillOval(100,100,100,100);

        g.setColor(Color.CYAN);
        g.fillRect(150, 200, 200, 200);
    }
}
