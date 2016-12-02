/* @(#)TillSys.java
 *
 * @Erwin Suarez
 * @version 1.00 2016/12/1
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.management.StringValueExp;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class TillSys extends JFrame implements ActionListener {

    JTextField displayTextField;

    JMenu fileMenu;
    JPanel container1, container2, container3, container4, container5;
    JPanel extrasPanel,numbersPanel,functionsPanel;
    JButton[] extras,numbers, functions;

    String tempString = "";
    String pressed;
    //public String user;
    double num1, num2;
    double tempValue = 0;
    double answer;
    int operation;


    public static void main(String[] args) {
        TillSys tillSys = new TillSys();
    }

    //Constructor creates the main window
    public TillSys () {

        //this will set the frame properties

        loginFileMenu();
        setTitle("Till System");
        setSize(1024, 720);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        //this will place the frame centered in the screen
        //copied from web in File
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        GridBagConstraints gbc = new GridBagConstraints();

        ButtonListener buttonListener = new ButtonListener();
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
        JTextArea text = new JTextArea();
        container1.add(text);

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
                //process = new JLabel();
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
                    extras[w].addActionListener(buttonListener);
                    extras[w].setEnabled(false);
                    extrasPanel.add(extras[w]);
                }
        container3.add(extrasPanel);
        container3.setBorder(BorderFactory.createLineBorder(Color.red));
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
                numbers = new JButton[10];
                for( int x = 9; x >= 0; x--) {
                    numbers[x] = new JButton(Integer.toString(x));
                    numbers[x].setFont(new Font("Segoe UI", Font.BOLD, 36));
                    numbers[x].addActionListener(buttonListener);
                    numbersPanel.add(numbers[x]);
                }
                    /*numbers[10] = new JButton(".");
                    numbers[10].setFont(new Font("Segoe UI", Font.BOLD, 36));
                    numbers[10].addActionListener(buttonListener);
                    numbersPanel.add(numbers[10]);
                    */
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
            //functions[y].addActionListener(buttonListener);
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
            tempString = String.valueOf(displayTextField.getText()) + pressed;
            displayTextField.setText(tempString);
        }
    }
                                            /*        switch (pressed) {
                                                        case "0":
                                                        case "1":
                                                        case "2":
                                                        case "3":
                                                        case "4":
                                                        case "5":
                                                        case "6":
                                                        case "7":
                                                        case "8":
                                                        case "9": {
                                                            displayTextField.setText(displayTextField.getText() + pressed);
                                                        }
                                                        break;

                                                        default:
                                                            num2 = Double.parseDouble(displayTextField.getText());
                                                            break;
                                                    }
                                                }
                                            }*/
    private class EnterButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            num2 = Double.parseDouble(displayTextField.getText());
            mathOperation();

            switch(operation){
                case 1:
                    answer = num1 * num2;
                    displayTextField.setText(Double.toString(answer));
                    break;
                case 2:
                    answer = num1 / num2;
                    displayTextField.setText(Double.toString(answer));
                    break;
                case 3:
                    tempString = "+";
                    displayTextField.setText(tempString);
                    tempString = "";
                    tempValue = num1 + num2;
                    displayTextField.setText(Double.toString(answer));
                    break;
                case 4:
                    answer = num1 - num2;
                    displayTextField.setText(Double.toString(answer));
                    break;
            }
        }
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
            num1 = Double.parseDouble(displayTextField.getText());
            tempString = "";
            displayTextField.setText(tempString);
            operation = 1;
        }
    }

    private class DivideButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            num1 = Double.parseDouble(displayTextField.getText());
            tempString = "";
            displayTextField.setText(tempString);
            tempString = "";
            operation = 2;
        }
    }

    private class AddButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            num1 = Double.parseDouble(String.valueOf(displayTextField.getText()));
            tempString = "+";
            displayTextField.setText(tempString);

            operation = 3;
        }
    }

    private class SubtractButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            num1 = Double.parseDouble(displayTextField.getText());
            tempString = "";
            displayTextField.setText(tempString);
            operation = 4;
        }
    }

    public void mathOperation() {

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
                answer = num1 + Double.parseDouble(displayTextField.getText());
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