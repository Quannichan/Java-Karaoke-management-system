package ManageKaraoke;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ConnectfailedFrame {
    int choose;
    mainFrame MainFrame;
    Signinframe SignInFrame;
    String[] response = { "Ok", "Cancel" };

    public ConnectfailedFrame() {
        ImageIcon icon = new ImageIcon("alert.gif");
        choose = JOptionPane.showOptionDialog(null, "Failed to connect, connect again?", "Connect Failed",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, icon, response,
                0);
        conmysql conn = new conmysql();
        if (conn.Connect() == "connect successfully!") {
            SignInFrame = new Signinframe();
        } else {
            if (choose == 0) {
                MainFrame = new mainFrame();
            }
        }
    }
}
