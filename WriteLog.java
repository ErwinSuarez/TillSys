/* @(#)WriteLog.java
 *
 * @author Erwin Suarez
 * @version 1.00 2016/11/15
 */

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class WriteLog {

    private ArrayList<String> logList = new ArrayList<String>();
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date dateobj = new Date();
    private Scanner in;

    public void createFile() throws FileNotFoundException{
        try {
            openFile();
        }
        catch(Exception e) {
            PrintWriter outStream = new PrintWriter(new File("DataLogger.txt"));
        }
    }

    public void openFile() {
        try{
            in = new Scanner(new File("DataLogger.txt"));
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "DataLogger file not found");
        }
    }

    public void readFile() {
        openFile();
        while(in.hasNext()){
            String d = in.next();
            String t = in.next();
            String u = in.next();

            System.out.printf("%s %s %s", d ,t ,u);
        }
    }
    public void recordFile(String message) {
        try {
            readFile();
            JOptionPane.showMessageDialog(null, "save");

        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot record file");
        }
    }

    public void addToLog (String message) {
        logList.add(df.format(dateobj) + " " +message);
    }

    public String toString () {
        String str = "";
        for (int i =0; i < logList.size(); i++) {
            str += logList.get(i) + "\n";
        }
        return str;
    }




}