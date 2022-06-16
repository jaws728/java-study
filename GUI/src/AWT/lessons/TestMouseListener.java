package AWT.lessons;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class TestMouseListener {
    public static void main(String[] args) {
        new MyFrame("画板");
    }
}

class MyFrame extends Frame{
    //画画需要画笔：监听鼠标当前位置
    //存储鼠标位置
    ArrayList points;

    public MyFrame(String str){
        super(str);
        setBounds(200,200,600,400);
        //鼠标监听器针对窗口
        points = new ArrayList<>();
        this.addMouseListener(new MyMouseListener());
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Iterator it = points.iterator();
        while (it.hasNext()) {
            Point p = (Point) it.next();
            g.setColor(Color.red);
            g.fillOval(p.x, p.y, 10,10);
        }
    }

    //添加点至界面
    public void addPaint(Point p) {
        points.add(p);
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            //获取当前对象
            MyFrame myFrame = (MyFrame) e.getSource();
            //获取鼠标的点
            addPaint(new Point(e.getX(), e.getY()));

            //每次点击需要重新画一遍
            repaint();
        }
    }
}
