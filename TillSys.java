/**
 * @(#)TillSys.java
 *
 * @Erwin Suarez
 * @version 1.00 2016/11/15
 */
import javax.swing.*;
 
public class TillSys extends JFrame {
	
	public static void main(String[] args){
		
		TillSys frame = new TillSys();
    }

    //Constructor creates the main windo
    public TillSys () {
        setTitle("Still System");
        setSize(600, 600);
        setLocationRelativeTo(null);
        MainContainer mainContainer = new MainContainer();
        Buttons buttons = new Buttons();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        add(mainContainer);
        add(buttons);

    }
}