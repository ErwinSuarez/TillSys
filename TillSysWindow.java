/*
 * @(#)TillSysWindow.java
 *
 *
 * @Erwin Suarez 
 * @version 1.00 2016/11/15
 */

import javax.swing.JFrame;

public class TillSysWindow extends JFrame{

    public TillSysWindow() {
    	
    	JFrame mainWindow = new JFrame("Till System");
    	mainWindow.setLocationRelativeTo(null);
    	mainWindow.setVisible(true);
    	mainWindow.setSize(640,480);
    	mainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
}