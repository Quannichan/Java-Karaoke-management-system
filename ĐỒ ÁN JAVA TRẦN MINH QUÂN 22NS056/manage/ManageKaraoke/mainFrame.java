package ManageKaraoke;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class mainFrame extends conmysql {
    JFrame MainFrame;
    JLabel ConnectingLabel;
    Signinframe SignInFrame;
    ConnectfailedFrame ConnectFaildedFrame;

    public mainFrame() {
        ConnectingLabel = new JLabel();
        ConnectingLabel.setText("Connecting...");
        ConnectingLabel.setForeground(Color.BLACK);
        ConnectingLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        ConnectingLabel.setVerticalAlignment(JLabel.CENTER);
        ConnectingLabel.setHorizontalAlignment(JLabel.CENTER);

        MainFrame = new JFrame();
        ImageIcon icon = new ImageIcon("icon.jpg");
        MainFrame.setIconImage(icon.getImage());
        MainFrame.getContentPane().setBackground(Color.WHITE);
        MainFrame.setTitle("Karaoke");
        MainFrame.setSize(300, 100);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setVisible(true);
        MainFrame.setResizable(false);
        MainFrame.setLocationRelativeTo(null);
        MainFrame.add(ConnectingLabel);
        conmysql conn = new conmysql();
        if (conn.Connect() == "connect successfully!") {
            MainFrame.dispose();
            SignInFrame = new Signinframe();
        } else {
            MainFrame.dispose();
            ConnectFaildedFrame = new ConnectfailedFrame();
        }
    }

}
