/**
 * @(#)TillSys.java
 *
 * @Erwin Suarez
 * @version 1.00 2016/11/15
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TillSys extends JFrame implements ActionListener{

    JTextField display;
    String displayArea = "123456789.0";
    public String user;
    JMenu fileMenu;
    JPanel container1, container2, container3, container4, container5;
    JButton[] button;
    JButton[] funct;

    //main driver
	public static void main(String[] args){
		
		TillSys winOne = new TillSys();
        winOne.setVisible(true);
    }//end driver

    //Constructor creates the main window
    public TillSys () {

        //this will set the frame properties
        setTitle("Till System");
        setSize(800, 640);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setVisible(true);

        //this will place the frame centered in the screen
        //copied from web in File
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        //contents = getContentPane();
        //contents.setLayout(new FlowLayout());

        container1 = new JPanel();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 40;
            gbc.weighty = 40;
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
            gbc.weighty = 60;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.BOTH;

            //special buttons area
            JTextArea extra = new JTextArea();
                container3.add(extra);
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
            JPanel numpad = new JPanel();
            JButton[] buttons = new JButton[10];
                numpad.setLayout(new GridLayout(4,3,10,10));
                for( int x = 9; x >= 0; x--) {
                    buttons[x] = new JButton(Integer.toString(x));
                    buttons[x].addActionListener(this);
                    numpad.add(buttons[x], gbc);
                }

            container4.add(numpad);
            container4.setBorder(BorderFactory.createLineBorder(Color.green));
        add(container4, gbc);


        container5 = new JPanel();
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.weightx = 25;
            gbc.weighty = 60;
            gbc.fill = GridBagConstraints.BOTH;

            //function buttins area
            container5.setLayout(new BorderLayout());
            JPanel function = new JPanel();
            JButton[] funct = new JButton[6];

                function.setLayout(new GridLayout(3,2,15,15));
                function.add(funct[5] = new JButton("+"));
                function.add(funct[4] = new JButton("-"));
                function.add(funct[3] = new JButton("*"));
                function.add(funct[2] = new JButton("/"));
                function.add(funct[1] = new JButton("C"));
                function.add(funct[0] = new JButton("Enter"));

            container5.setBorder(BorderFactory.createLineBorder(Color.blue));
            container5.add(function);

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
    }



}