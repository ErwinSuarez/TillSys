/* @(#)LoginFrame.java
 *
 * @Erwin Suarez
 * @version 1.00 2016/11/15
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends JFrame {

    JPanel panel;
    private JTextField userText;
    TillSys parent;

    public LoginFrame (TillSys parent) {
        this.parent = parent;

        setSize(320, 150);
        setTitle("Login");
        setLocationRelativeTo(parent);
        panel = new JPanel(new FlowLayout());

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);

        userText.setText(userText.getText());


        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new BtnHandler());
        add(panel);

        //hides the main window
        parent.setVisible(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                login();
            }
        });
    }

    public class BtnHandler implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            login();
        }
    }

    private void login () {
        LoginFrame.this.dispose();
        parent.setVisible(true);
        parent.setUserName(userText.getText());
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
    }
}