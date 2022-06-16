package AWT.component;

import java.awt.*;

public class MyFrame extends Frame {
    // for generating multiple windows
    static int id = 0;

    public MyFrame(int x, int y, int h, int w, Color c) throws HeadlessException {
        super("My Frame - " + ++id);
        setBounds(x,y,h,w);
        setBackground(c);
        setResizable(false);
        setVisible(true);
    }
}
