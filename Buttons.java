/**
 * @(#)TillSys.java
 *
 * @Erwin Suarez
 * @version 1.00 2016/11/15
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Buttons extends JFrame implements ActionListener {

    private JPanel localPanel;
    private JButton button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9;


    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");

    public Buttons(){

        int row = 4;
        int col = 3;

        GridLayout numpad = new GridLayout(row,col,5,5);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


        //setLayout(new GridLayout(row,col,5,5));
        //setSize(600,500);
        //setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //add(localPanel);
        //add(localPanel, BorderLayout.CENTER);


        button0 = new JButton("0");
        button0.addActionListener(this);
        button1 = new JButton("1");
        button1.addActionListener(this);
        button2 = new JButton("2");
        button2.addActionListener(this);
        button3 = new JButton("3");
        button3.addActionListener(this);
        button4 = new JButton("4");
        button5.addActionListener(this);
        button5 = new JButton("5");
        button5.addActionListener(this);
        button6 = new JButton("6");
        button6.addActionListener(this);
        button7 = new JButton("7");
        button7.addActionListener(this);
        button8 = new JButton("8");
        button8.addActionListener(this);
        button9 = new JButton("9");
        button9.addActionListener(this);


    JPanel numpad = new JPanel();



        add(button0);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);

    }

}
