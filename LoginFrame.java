/**
 * Created by t00189596 on 22/11/2016.
 */
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends JFrame {
    public LoginFrame (TillSys parent) {
        setSize(400, 400);
        setTitle("Login");

        parent.setVisible(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parent.setVisible(true);

                LoginFrame.this.dispose();
            }
        });
    }

    {}
}
