package Swing.lessons;

import javax.swing.*;
import java.awt.*;

public class IconDemo extends JFrame implements Icon {
    private int width;
    private int height;

    public IconDemo() {
    }

    public IconDemo(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void init() {
        IconDemo iconDemo = new IconDemo(15, 15);

        //图标可放置：标签、按钮之上
        JLabel jLabel = new JLabel("", iconDemo, SwingConstants.CENTER);
        Container c = getContentPane();
        c.add(jLabel);

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new IconDemo().init();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x, y, width, height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }
}
