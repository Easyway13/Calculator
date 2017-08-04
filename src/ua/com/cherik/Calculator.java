package ua.com.cherik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator implements ActionListener {


    JPanel windowContent;
    JTextField displayField;
    JButton[] button = new JButton[10];
    JButton buttonPoint;
    JButton buttonEqual;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonMultiply;
    JButton buttonDivide;
    JButton buttonClean;
    JPanel p1;
    JPanel p2;
    JPanel p3;
    int temp;
    double firstNum;
    double secondNum;
    String operation;
    ArrayList<String> mathOperation;

    Calculator(){
        temp = 0;
        windowContent= new JPanel();

        BorderLayout bl= new BorderLayout();
        windowContent.setLayout(bl);

        displayField = new JTextField(30);
        displayField.setText("");
        windowContent.add("North", displayField);


        for(int i = 0; i < 10; i++) {
            button[i] = new JButton(""+i);
            button[i].addActionListener(this);
        }

        buttonPoint= new JButton(".");
        buttonEqual= new JButton("=");
        buttonEqual.setSize(80, 80);
        buttonPlus= new JButton("+");
        buttonMinus= new JButton("-");
        buttonMultiply= new JButton("*");
        buttonDivide= new JButton("/");
        buttonClean = new JButton("C");

        buttonEqual.setSize(100,200);

        buttonPoint.addActionListener(this);
        buttonEqual.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonMultiply.addActionListener(this);
        buttonDivide.addActionListener(this);
        buttonClean.addActionListener(this);


        p1=new JPanel();
        GridLayout gl= new GridLayout(4,3);
        p1.setLayout(gl);

        for(int i = 1; i <= 10; i++) {
            if(i==10)
                p1.add(button[0]);
            else
                p1.add(button[i]);
        }
        p1.add(buttonPoint);
        p1.add(buttonClean);

        windowContent.add(p1, BorderLayout.CENTER);
        p2= new JPanel();
        p2.setLayout(new GridLayout(0,2));
        p2.add(buttonMinus);
        p2.add(buttonPlus);
        p2.add(buttonDivide);
        p2.add(buttonMultiply);


        JPanel pEast = new JPanel(new GridLayout(0,1));
        windowContent.add(pEast, BorderLayout.EAST);
        pEast.add(p2);
        pEast.add(buttonEqual);

        JFrame frame= new JFrame("Calculator");
        frame.setContentPane(windowContent);

        frame.pack();

        frame.setVisible(true);


    }
    public static void main(String[] args){
        Calculator calc= new Calculator();
    }


    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button[0])
            displayField.setText(displayField.getText() + "0");
        if(e.getSource() == button[1])
            displayField.setText(displayField.getText() + "1");
        if(e.getSource() == button[2])
            displayField.setText(displayField.getText() + "2");
        if(e.getSource() == button[3])
            displayField.setText(displayField.getText() + "3");
        if(e.getSource() == button[4])
            displayField.setText(displayField.getText() + "4");
        if(e.getSource() == button[5])
            displayField.setText(displayField.getText() + "5");
        if(e.getSource() == button[6])
            displayField.setText(displayField.getText() + "6");
        if(e.getSource() == button[7])
            displayField.setText(displayField.getText() + "7");
        if(e.getSource() == button[8])
            displayField.setText(displayField.getText() + "8");
        if(e.getSource() == button[9])
            displayField.setText(displayField.getText() + "9");

        if(e.getSource() == buttonPlus)
        {
            firstNum = Double.parseDouble(displayField.getText());
            displayField.setText("");
            operation = "+";
        }
        if(e.getSource() == buttonMinus)
        {
            firstNum = Double.parseDouble(displayField.getText());
            displayField.setText("");
            operation = "-";
        }
        if(e.getSource() == buttonMultiply)
        {
            firstNum = Double.parseDouble(displayField.getText());
            displayField.setText("");
            operation = "*";
        }
        if(e.getSource() == buttonDivide)
        {
            firstNum = Double.parseDouble(displayField.getText());
            displayField.setText("");
            operation = "/";
        }
        if(e.getSource() == buttonEqual)
        {
            secondNum = Double.parseDouble(displayField.getText());
            if(operation.equals("+"))
                displayField.setText(firstNum+secondNum+"");
            if(operation.equals("-"))
                displayField.setText(firstNum-secondNum+"");
            if(operation.equals("*"))
                displayField.setText(firstNum*secondNum+"");
            if(operation.equals("/"))
                displayField.setText(firstNum/secondNum+"");
        }
        if(e.getSource() == buttonClean)
        {
            String tmp = displayField.getText();
            String temp = tmp.substring(0, tmp.length() -1);
            displayField.setText(temp);
        }
    }

    public double result(ArrayList s)
    {
        double res =0;
        for(int i =0; i< s.size(); i++)
        {
            if(s.get(i).equals("+"))
            {
                res = Double.parseDouble(mathOperation.get(i-1)) + Double.parseDouble(mathOperation.get(i+1));
            }
        }
        return res;
    }


}

