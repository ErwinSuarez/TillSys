/* @(#)TillSys.java
 *
 * @author Erwin Suarez
 * @version 1.00 2016/11/15
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class TillSys extends JFrame implements ActionListener {

    JTextField displayTextField;

    JMenu fileMenu;
    JPanel container1, container2, container3, container4, container5;
    JPanel loginPanel, extrasPanel,numbersPanel,functionsPanel;
    JButton[] extras,numbers, functions;
    JLabel userLabel;

    String tempString = "";
    String pressed;
    static String userName = "Guest";
    double num1, num2;
    double tempValue = 0;
    double answer;
    int operation;
    private boolean isCalculated = false;
    public boolean isLog = false;
    double runningTotal=0;
    WriteLog logFile;

    /**
     * This is the main driver creating instance of TillSys
     * @param args
     */
    public static void main(String[] args) {
        TillSys tillSys = new TillSys();
    }

    /**
     * constructor that creates the whole window with all the panels added into it
     * this also includes the login menu bar across the top of the window
     */
    public TillSys () {

        loginFileMenu();
        placement();

        logFile = new WriteLog();
    }

    /**
     * This create the whole window and places all the panels into specified
     * placements. this also calls the login menubar
     */
    private void placement(){

        setTitle("Till System");
        setSize(1024, 720);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        //this will place the frame centered in the screen
        /**
         * the setLocation method sets the page on desired location.
         * dim stores the value of the current setting for the screen so that desired location can be set
         */
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        GridBagConstraints gbc = new GridBagConstraints();

        ButtonListener buttonListener = new ButtonListener();
        ExtrasListener extrasListener = new ExtrasListener();
        EnterButton enter = new EnterButton();
        CancelButton cancel = new CancelButton();
        MultiplyButton multiply = new MultiplyButton();
        DivideButton divide = new DivideButton();
        AddButton add = new AddButton();
        SubtractButton subtract = new SubtractButton();
        JMenuBar menuBar = new JMenuBar();


        //login panel
        container1 = new JPanel();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 224;
            gbc.weighty = 300;
            gbc.fill = GridBagConstraints.BOTH;

            //login area
            loginPanel = new JPanel(new FlowLayout());
            userLabel = new JLabel(userName);
            userLabel.setFont(new Font("Segoe UI", Font.BOLD, 48));
            loginPanel.add(userLabel);
        container1.add(loginPanel);
        container1.setBorder(BorderFactory.createLineBorder(Color.black));
        add(container1, gbc);

        //display panel
        container2 = new JPanel();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.weighty = 40;
            gbc.gridwidth = GridBagConstraints.HORIZONTAL;
            gbc.fill = GridBagConstraints.BOTH;

            //display screen
            displayTextField = new JTextField();
            displayTextField.setText(displayTextField.getText());
            displayTextField.setLayout(new BorderLayout());
            displayTextField.setFont(new Font("Segoe UI", Font.BOLD, 48));
            displayTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        container2.setLayout(new BorderLayout());
        container2.add(displayTextField);
        container2.setBorder(BorderFactory.createLineBorder(Color.yellow));
        add(container2, gbc);

        //special buttons panel
        container3 = new JPanel();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 40;
            gbc.weighty = 300;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(10,10,10,10);

            //special buttons
            container3.setLayout(new BorderLayout());
            container3.setPreferredSize(new Dimension(300,400));
            extrasPanel = new JPanel(new GridLayout(4,2,10,10));
            extras = new JButton[8];
            extras[7] = new JButton("Item 7");
            extras[6] = new JButton("Item 6");
            extras[5] = new JButton("Item 5");
            extras[4] = new JButton("Item 4");
            extras[3] = new JButton("Item 3");
            extras[2] = new JButton("Item 2");
            extras[1] = new JButton("Item 1");
            extras[0] = new JButton("View Log");

            for( int w = 0; w <= 7; w++) {
                extras[w].setFont(new Font("Segoe UI", Font.BOLD, 14));
                extras[w].addActionListener(extrasListener);
                //extras[w].setEnabled(false);
                extrasPanel.add(extras[w]);
            }
        container3.add(extrasPanel);
        //container3.setBorder(BorderFactory.createLineBorder(Color.red));
        add(container3, gbc);

        //numbers panel
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
            numbers = new JButton[11];
            for( int x = 9; x >= 0; x--) {
                numbers[x] = new JButton(Integer.toString(x));
                numbers[x].setFont(new Font("Segoe UI", Font.BOLD, 36));
                numbers[x].addActionListener(buttonListener);
                numbersPanel.add(numbers[x]);
            }
            numbers[10] = new JButton(".");
            numbers[10].setFont(new Font("Segoe UI", Font.BOLD, 36));
            numbers[10].addActionListener(buttonListener);
            numbersPanel.add(numbers[10]);
        container4.add(numbersPanel);
        container2.setBorder(BorderFactory.createLineBorder(Color.green));
        add(container4, gbc);

        //functions panel
        container5 = new JPanel();
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.weightx = 25;
            gbc.weighty = 60;
            gbc.fill = GridBagConstraints.BOTH;

        //function buttons area
        container5.setLayout(new BorderLayout());
        container5.setPreferredSize(new Dimension(200,400));
            functionsPanel = new JPanel();
            functions = new JButton[6];
            functionsPanel.setLayout(new GridLayout(3,2,15,15));
            functionsPanel.add(functions[5] = new JButton("+"));
            functionsPanel.add(functions[4] = new JButton("-"));
            functionsPanel.add(functions[3] = new JButton("*"));
            functionsPanel.add(functions[2] = new JButton("/"));
            functionsPanel.add(functions[1] = new JButton("C"));
            functionsPanel.add(functions[0] = new JButton("Enter"));
            for( int y = 5; y >= 0; y--) {
                functions[y].setFont(new Font("Segoe UI", Font.BOLD, 36));
                functionsPanel.add(functions[y]);
            }
            functions[5].addActionListener(add);
            functions[4].addActionListener(subtract);
            functions[3].addActionListener(multiply);
            functions[2].addActionListener(divide);
            functions[1].addActionListener(cancel);
            functions[0].addActionListener(enter);
        container5.add(functionsPanel);
        container2.setBorder(BorderFactory.createLineBorder(Color.blue));
        add(container5, gbc);

        setJMenuBar(menuBar);
        menuBar.setBackground(Color.lightGray);
        menuBar.add(fileMenu);
        setVisible(true);
    }

    /**
     * This sets the username to whateve the user enters
     * @param userName
     */
    public void setUserName (String userName) {
        this.userName = userName;
        userLabel.setText(userName);
    }

    public static String getUserName()
    {
        return TillSys.userName;
    }

    /**
     * This handles the menu options
     * @param menuEvent
     */
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

    //number buttons
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent pressedButton) {
            pressed = pressedButton.getActionCommand();
            if (!isCalculated) {
                tempString = String.valueOf(displayTextField.getText()) + pressed;
            }

            else {tempString = pressed;}

            isCalculated = false;
            displayTextField.setText(tempString);
        }
    }

    private class ExtrasListener implements ActionListener {
        public void actionPerformed(ActionEvent pressedButton) {
            // check if log file button
            System.out.println("Clicking extras button");
            System.out.println(logFile.toString());
        }
    }

    private class EnterButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            num2 = Double.parseDouble(displayTextField.getText());
            mathOperation(num2);

            switch(operation){
                case 1:
                    logFile.addToLog("Multiplying " + num1 + " and " + num2);
                    answer = num1 * num2;
                    displayTextField.setText(Double.toString(answer));
                    break;
                case 2:
                    logFile.addToLog("Dividing " + num1 + " and " + num2);
                    answer = num1 / num2;
                    displayTextField.setText(Double.toString(answer));
                    break;
                case 3:
                    tempString = "+";
                    displayTextField.setText(tempString);
                    tempString = "";
                    tempValue = num1 + num2;
                    displayTextField.setText(Double.toString(tempValue));
                    break;
                case 4:
                    answer = num1 - num2;
                    displayTextField.setText(Double.toString(answer));
                    break;
            }

            isCalculated = true;
        }
    }

    /**
     * this checks if string passed into isNumeric is a number
     * @param str
     * @return
     */
    public static boolean isNumeric(String str)
    {
        try {
            double d = Double.parseDouble(str);
        }

        catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private class CancelButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            tempString = "";
            displayTextField.setText(tempString);
        }
    }

    private class MultiplyButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String enteredVal = String.valueOf(displayTextField.getText());

            if (isNumeric(enteredVal)) {
                num1 = Double.parseDouble(displayTextField.getText());
                tempString = "";
                displayTextField.setText(tempString);
                operation = 1;
            }
        }
    }

    private class DivideButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String enteredVal = String.valueOf(displayTextField.getText());

            if (isNumeric(enteredVal)) {
                num1 = Double.parseDouble(displayTextField.getText());
                tempString = "";
                displayTextField.setText(tempString);
                tempString = "";
                operation = 2;
            }
        }
    }

    private class AddButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String enteredVal = String.valueOf(displayTextField.getText());

            if (isNumeric(enteredVal)) {
                num1 = Double.parseDouble(enteredVal);
                tempString = "";
                displayTextField.setText(tempString);

                operation = 3;

            }
        }
    }

    private class SubtractButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String enteredVal = String.valueOf(displayTextField.getText());

            if (isNumeric(enteredVal)) {
                num1 = Double.parseDouble(displayTextField.getText());
                tempString = "";
                displayTextField.setText(tempString);

                operation = 4;
            }
        }
    }

    public void mathOperation(double num2) {

        switch(operation){
            case 1:     //multiply
                answer = num1 * Double.parseDouble(displayTextField.getText());
                displayTextField.setText(Double.toString(answer));
                break;
            case 2:     //divide
                answer = num1 / Double.parseDouble(displayTextField.getText());
                displayTextField.setText(Double.toString(answer));
                break;
            case 3:     //add
                String fieldString = displayTextField.getText();

                if(!fieldString.equals("+"))
                     answer = num2 + Double.parseDouble(displayTextField.getText());
                displayTextField.setText(Double.toString(answer));
                break;
            case 4:     //subtract
                answer = num1 - Double.parseDouble(displayTextField.getText());
                displayTextField.setText(Double.toString(answer));
                break;
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




}