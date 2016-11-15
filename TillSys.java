/**
 * @(#)TillSys.java
 *
 *
 * @Erwin Suarez
 * @version 1.00 2016/11/15
 */
import javax.swing.*;
 
public class TillSys extends JFrame {
	
	public static void main(String[] args){
		
		TillSys frame = new TillSys();

        frame.setVisible(true);
    }
    
    public TillSys () {
        setTitle("My Frame");

        setSize(600, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}