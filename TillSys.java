/**
 * @(#)TillSys.java
 *
 * @Erwin Suarez
 * @version 1.00 2016/11/15
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.Arc2D;

public class TillSys extends JFrame implements ActionListener {

    JTextField display;

    JMenu fileMenu;
    JPanel container1, container2, container3, container4, container5;
    JPanel extrasPanel,numbersPanel,functionsPanel;

    JButton[] extras,numbers, functions;

    String tempVal = "", displayArea = "123456789.0";
    //public String user;
    double num1 = 0, num2 = 0;

    //main driver
	public static void main(String[] args) {
		TillSys winOne = new TillSys();
        winOne.setVisible(true);
    }//end driver

    //Constructor creates the main window
    public TillSys () {

        //this will set the frame properties
        setTitle("Till System");
        setSize(1024, 800);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setVisible(true);

        //this will place the frame centered in the screen
        //copied from web in File
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        //login panel
        container1 = new JPanel();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 324;
            gbc.weighty = 300;
            gbc.fill = GridBagConstraints.BOTH;

            //login area
            JTextArea text = new JTextArea();
                container1.add(text);
                loginFileMenu();
                container1.setBorder(BorderFactory.createLineBorder(Color.black));
        add(container1, gbc);


        container2 = new JPanel();
            gbc.gridx = 1;
            gbc.gridy = 0;

            gbc.weighty = 40;
            gbc.gridwidth = GridBagConstraints.HORIZONTAL;
            gbc.fill = GridBagConstraints.BOTH;

            //display screen
            display = new JTextField();
            display.setLayout(new BorderLayout());
            display.setFont(new Font("Segoe UI", Font.BOLD, 48));
            container2.setLayout(new BorderLayout());
            container2.add(display);
            container2.setBorder(BorderFactory.createLineBorder(Color.yellow));
        add(container2, gbc);


        container3 = new JPanel();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 40;
            gbc.weighty = 300;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(10,10,10,10);


            //special buttons area
            container3.setLayout(new BorderLayout());
            container3.setPreferredSize(new Dimension(300,400));
            extrasPanel = new JPanel(new GridLayout(4,2,10,10));
            extras = new JButton[8];
                extras[7] = new JButton("Open7");
                extras[6] = new JButton("Close6");
                extras[5] = new JButton("Edit5");
                extras[4] = new JButton("Delete4");
                extras[3] = new JButton("Open3");
                extras[2] = new JButton("Close2");
                extras[1] = new JButton("Edit1");
                extras[0] = new JButton("Delete0");

                for( int w = 7; w >= 0; w--) {

                    extras[w].setFont(new Font("Segoe UI", Font.BOLD, 14));
                    extras[w].addActionListener(this);
                    extrasPanel.add(extras[w]);
                }

            container3.add(extrasPanel);
            container3.setBorder(BorderFactory.createLineBorder(Color.red));
        add(container3, gbc);


        container4 = new JPanel();
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.weightx = 35;
            gbc.weighty = 40;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(10,10,10,10);

            //numbers buttons area
            container4.setLayout(new BorderLayout());
            container4.setPreferredSize(new Dimension(500,400));
            numbersPanel = new JPanel();
            numbersPanel.setLayout(new GridLayout(4,3,10,10));
            numbers = new JButton[10];
                for( int x = 9; x >= 0; x--) {
                    numbers[x] = new JButton(Integer.toString(x));
                    numbers[x].setFont(new Font("Segoe UI", Font.BOLD, 36));
                    numbers[x].addActionListener(this);
                    numbersPanel.add(numbers[x]);
                }

            container4.add(numbersPanel);
            container2.setBorder(BorderFactory.createLineBorder(Color.green));
        add(container4, gbc);


        container5 = new JPanel();
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.weightx = 25;
            gbc.weighty = 60;
            gbc.fill = GridBagConstraints.BOTH;

            //function buttins area
            container5.setLayout(new BorderLayout());
            container5.setPreferredSize(new Dimension(200,400));
            functionsPanel = new JPanel();
            functions = new JButton[6];

            //call the buttons to listen
            ButtonListener btnListener = new ButtonListener();

                functionsPanel.setLayout(new GridLayout(3,2,15,15));
                functionsPanel.add(functions[5] = new JButton("+"));
                functionsPanel.add(functions[4] = new JButton("-"));
                functionsPanel.add(functions[3] = new JButton("*"));
                functionsPanel.add(functions[2] = new JButton("/"));
                functionsPanel.add(functions[1] = new JButton("C"));
                functionsPanel.add(functions[0] = new JButton("Enter"));
                for( int y = 5; y >= 0; y--) {
                    functions[y].setFont(new Font("Segoe UI", Font.BOLD, 36));
                    functions[y].addActionListener(btnListener);
                    functionsPanel.add(functions[y]);
                }
            container5.add(functionsPanel);
            container2.setBorder(BorderFactory.createLineBorder(Color.blue));

        add(container5, gbc);
        setVisible(true);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.lightGray);
        menuBar.add(fileMenu);
    }

    public void actionPerformed(ActionEvent menuEvent){
        String menuName;
            menuName = menuEvent.getActionCommand();

        if (menuName.equals("Quit")) {
            System.exit(0);
        } else if (menuName.equals("Member")) {
            // show input screen for member
            LoginFrame memberLogin = new LoginFrame(TillSys.this);
            memberLogin.setVisible(true);
        } else if (menuName.equals("Administrator")) {
            // show input screen for administrator
            LoginFrame adminLogin = new LoginFrame(TillSys.this);
            adminLogin.setVisible(true);
        }
        //System.out.println(menuName);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent pressedButton){

            String pressed;
            pressed = pressedButton.getActionCommand();

            switch (pressed) {
                case "0" :
                case "1" :
                case "2" :
                case "3" :
                case "4" :
                case "5" :
                case "6" :
                case "7" :
                case "8" :
                case "9" : {
                    tempVal += pressed;
                    break;
                }
                case "+" :
                    num1 = Double.parseDouble(tempVal);
                    tempVal = "";
                    break;
                case "-" :
                    break;
                case "/" :
                    break;
                case "*" :
                    break;
                case "C" :
                    break;
                case "Enter" :
                    break;

                default:
                    break;

            }
            System.out.println(pressed);
        }
    }


    private void loginFileMenu(){

        JMenuItem item;

        fileMenu = new JMenu("Login");

        item = new JMenuItem("Administrator");
        item.addActionListener(this);
        fileMenu.add(item);

        item = new JMenuItem("Member");
        item.addActionListener(this);
        fileMenu.add(item);

        item = new JMenuItem("Quit");
        item.addActionListener(this);
        fileMenu.add(item);
    }

    /*
    private class Enter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            temp = Double.parseDouble(display.getText());

                if (function == 0) {
                    display.setText(Double.toString((Math.round((num1 / num2) * 100)) / 100));
                } else if (function == 1) {
                    display.setText(Double.toString(num1 * num2));
                } else if (function == 2) {
                    display.setText(Double.toString(num2 + num1));
                } else if (function == 3) {
                    display.setText(Double.toString(num1 - num2));
                } else {
                    display.setText(String.valueOf(num1));
                }
                num1 = Double.parseDouble(display.getText());
            }
        }
    }


    private class Cancel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class Multiply implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class Divide implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class Add implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class Subtract implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }*/

}