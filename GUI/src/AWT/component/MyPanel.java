package AWT.component;

import java.awt.*;

public class MyPanel extends Panel{
    public MyPanel(int x, int y, int h, int w, Color c) {
        super();
        setBounds(x,y,h,w);
        setBackground(c);
    }
}
