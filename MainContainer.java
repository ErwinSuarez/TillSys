/**
 * @(#)MainContainer.java
 *
 * @Erwin Suarez
 * @version 1.00 2016/11/15
 */
import javax.swing.*;
import java.awt.*;

public class MainContainer extends Container {

    public MainContainer() {
        setLayout(new FlowLayout());

        JLabel myLabel = new JLabel("Hello World");

        add(myLabel);
    }

}
