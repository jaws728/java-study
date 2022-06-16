package AWT.app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 简易计算器
public class SimpleCalculator {
    public static void main(String[] args) {
        new Calculator().loadFrame();
    }
}

// 计算器类: 3个文本框 + 1个按钮 + 1个标签
class Calculator extends Frame {
    TextField textField1, textField2, textField3;

    public void loadFrame() {
        textField1 = new TextField(10);
        textField2 = new TextField(10);
        textField3 = new TextField(20);
        Button button = new Button("=");
        Label label = new Label("+");

        setLayout(new FlowLayout());
        //button.addActionListener(new ResultList(this));
        button.addActionListener(new ResListener());

        add(textField1);
        add(label);
        add(textField2);
        add(button);
        add(textField3);
        pack();
        setVisible(true);
    }

    // 使用内部类: 可以畅通无阻的访问外部类 -- 更好的包装
    private class ResListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double n1 = Double.parseDouble(textField1.getText());
            double n2 = Double.parseDouble(textField2.getText());
            textField3.setText("" + (n1+n2));
            textField1.setText("");
            textField2.setText("");
        }
    }

    /* 只使用构造器
    public Calculator() {
        TextField textField1 = new TextField(10);
        TextField textField2 = new TextField(10);
        TextField textField3 = new TextField(20);
        Button button = new Button("=");
        Label label = new Label("+");

        // 流式布局
        setLayout(new FlowLayout());

        // 添加事件
        button.addActionListener(new ResultListener(textField1, textField2, textField3));

        // 添加内容
        add(textField1);
        add(label);
        add(textField2);
        add(button);
        add(textField3);

        // 适应大小
        pack();

        // 显示
        setVisible(true);
    }*/
}

//监听器类
class ResultListener implements ActionListener {
    // 获取3个变量
    private TextField num1, num2, num3;
    public ResultListener(TextField num1, TextField num2, TextField num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double n1 = Double.parseDouble(num1.getText());
        double n2 = Double.parseDouble(num2.getText());
        double n3 = n1 + n2;
        num3.setText(String.valueOf(n3));
        // 清空1、2框
        num1.setText("");
        num2.setText("");
    }
}
// 使用外部类
class ResultList implements ActionListener {
    private Calculator c = null;

    public ResultList(Calculator c) {
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double n1 = Double.parseDouble(c.textField1.getText());
        double n2 = Double.parseDouble(c.textField2.getText());
        c.textField3.setText("" + (n1 + n2));
        // 清空1、2框
        c.textField1.setText("");
        c.textField2.setText("");
    }
}
