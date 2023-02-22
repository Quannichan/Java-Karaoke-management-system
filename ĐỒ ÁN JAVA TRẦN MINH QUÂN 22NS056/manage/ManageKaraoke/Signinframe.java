package ManageKaraoke;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signinframe extends conmysql implements ActionListener {
    JFrame SigninFrame;
    JLabel LabelOfSignin;
    JTextArea SignInText, UserNameText, EmailText, PasswordText;
    JTextField UserNameTextField, EmailTextField; // loginText
    JPasswordField PasswordTextField;
    JButton NextButton, ForgetPUButton, NewAccountButton;
    CheckEmail check = new CheckEmail();
    Border BlackBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
    Border WhiteBorder = BorderFactory.createLineBorder(Color.WHITE, 3);
    ImageIcon Image = new ImageIcon("micro.jpg");
    ImageIcon icon = new ImageIcon("icon.jpg");
    JCheckBox show;
    String Email, UserName;
    String PASS, USERNAME,EMAIL;
    Font BigFont = new Font("Serif", Font.BOLD, 50);
    Font MediumFont = new Font("Serif", Font.BOLD, 18);
    Font SmallFont = new Font("Serif", Font.BOLD, 16);
    SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    Date date = new Date();
    
    public Signinframe() {
        this.SignInText = new JTextArea();
        this.SignInText.setText("Sign in");
        this.SignInText.setBounds(380, 40, 149, 65);
        this.SignInText.setFont(this.BigFont); 
        this.SignInText.setEditable(false);

        this.UserNameText = new JTextArea();
        this.UserNameText.setText("User name");
        this.UserNameText.setBounds(250, 120, 90, 22);
        this.UserNameText.setFont(this.MediumFont);
        this.UserNameText.setEditable(false);

        this.EmailText = new JTextArea();
        this.EmailText.setText("Email");
        this.EmailText.setBounds(250, 178, 90, 22);
        this.EmailText.setFont(this.MediumFont);
        this.EmailText.setEditable(false);

        this.PasswordText = new JTextArea();
        this.PasswordText.setText("Password");
        this.PasswordText.setBounds(250, 236, 90, 22);
        this.PasswordText.setFont(this.MediumFont);
        this.PasswordText.setEditable(false);

        this.UserNameTextField = new JTextField();
        this.UserNameTextField.setBounds(340, 123, 300, 25);
        this.UserNameTextField.setBorder(this.BlackBorder);
        this.UserNameTextField.setFont(this.SmallFont);

        this.EmailTextField = new JTextField();
        this.EmailTextField.setBounds(340, 180, 300, 25);
        this.EmailTextField.setBorder(this.BlackBorder);
        this.EmailTextField.setFont(this.SmallFont);

        this.PasswordTextField = new JPasswordField();
        this.PasswordTextField.setBounds(340, 237, 300, 25);
        this.PasswordTextField.setBorder(this.BlackBorder);
        this.PasswordTextField.setFont(this.SmallFont);

        this.show = new JCheckBox("Show Password");
        this.show.setBounds(340, 270, 200, 30);
        this.show.setBackground(Color.white);
        this.show.addActionListener(this);
        this.show.setFocusable(false);

        this.NextButton = new JButton("Next");
        this.NextButton.setBounds(415, 320, 80, 23);
        this.NextButton.setFocusable(false);
        this.NextButton.setFont(this.SmallFont);
        this.NextButton.addActionListener(this);

        this.ForgetPUButton = new JButton("Forgot password or username?");
        this.ForgetPUButton.setBounds(332, 355, 250, 23);
        this.ForgetPUButton.setBackground(Color.WHITE);
        this.ForgetPUButton.setOpaque(true);
        this.ForgetPUButton.setBorder(this.WhiteBorder);
        this.ForgetPUButton.setFocusable(false);
        this.ForgetPUButton.setFont(this.SmallFont);
        this.ForgetPUButton.addActionListener(this);

        this.NewAccountButton = new JButton("Don't have account, make new!");
        this.NewAccountButton.setBounds(320, 390, 270, 23);
        this.NewAccountButton.setFocusable(false);
        this.NewAccountButton.setFont(this.SmallFont);
        this.NewAccountButton.setBackground(Color.WHITE);
        this.NewAccountButton.setOpaque(true);
        this.NewAccountButton.setBorder(this.WhiteBorder);
        this.NewAccountButton.addActionListener(this);

        this.LabelOfSignin = new JLabel();
        this.LabelOfSignin.setSize(700, 470);
        this.LabelOfSignin.setVisible(true);
        this.LabelOfSignin.setBackground(Color.white);
        this.LabelOfSignin.setOpaque(true);
        this.LabelOfSignin.setIcon(this.Image);
        this.LabelOfSignin.add(this.SignInText);
        this.LabelOfSignin.add(this.UserNameText);
        this.LabelOfSignin.add(this.EmailText);
        this.LabelOfSignin.add(this.PasswordText);
        this.LabelOfSignin.add(this.UserNameTextField);
        this.LabelOfSignin.add(this.EmailTextField);
        this.LabelOfSignin.add(this.PasswordTextField);
        this.LabelOfSignin.add(this.show);
        this.LabelOfSignin.add(this.NextButton);
        this.LabelOfSignin.add(this.ForgetPUButton);
        this.LabelOfSignin.add(this.NewAccountButton);

        this.SigninFrame = new JFrame("Sign in");
        this.SigninFrame.setLayout(null);
        this.SigninFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.SigninFrame.setResizable(false);
        this.SigninFrame.setIconImage(this.icon.getImage());
        this.SigninFrame.setSize(700, 470);
        this.SigninFrame.setLocationRelativeTo(null);
        this.SigninFrame.setVisible(true);
        this.SigninFrame.add(this.LabelOfSignin);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.show.isSelected()) {
            this.PasswordTextField.setEchoChar((char) 0);
        } else {
            this.PasswordTextField.setEchoChar('*');
        }

        if (e.getSource() == this.NewAccountButton) {
            new NewAccount();
        } else {

        }

        if (e.getSource() == this.ForgetPUButton) {
            new forgetPU();
        } else {
        }

        if (e.getSource() == this.NextButton) {
            if (this.UserNameTextField.getText().length() != 0) {
                if (this.UserNameTextField.getText().length() >= 7) {
                    if (this.EmailTextField.getText().length() != 0) {
                        if (this.EmailTextField.getText().length() >= 10) {
                            if (this.check.CheckEmail(this.EmailTextField.getText()) == true) {
                                if (this.PasswordTextField.getText().length() != 0) {
                                    if (this.PasswordTextField.getText().length() >= 8) {
                                        try {
                                            Connection connection = DriverManager.getConnection(DB_URL, USER_NAME,
                                                    PASSWORD);
                                            Statement stmt = connection.createStatement();
                                            ResultSet rs = stmt
                                                    .executeQuery(
                                                            "Select UserName, Email, cast(aes_decrypt(pass,'key123') as char) as showpass from Karaoke.UserList");
                                            ArrayList<String> UN = new ArrayList<String>();
                                            ArrayList<String> Email = new ArrayList<String>();
                                            ArrayList<String> pass = new ArrayList<String>();
                                            while (rs.next()) {
                                                UN.add(rs.getString(1));
                                                Email.add(rs.getString(2));
                                                pass.add(rs.getString(3));
                                            }
                                            connection.close();
                                            if (UN.contains(this.UserNameTextField.getText()) == true) {
                                                if (Email.contains(this.EmailTextField.getText()) == true) {
                                                    if (pass.contains(this.PasswordTextField.getText()) == true) {
                                                        try{
                                                            Connection connection2 = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                                                            Statement stmt2 = connection2.createStatement();
                                                            ResultSet rs2 = stmt2.executeQuery("Select UserName, Email, cast(aes_decrypt(pass,'key123') as char) as showpass from Karaoke.UserList where Email = '"+this.EmailTextField.getText()+"'");
                                                            while (rs2.next()) {
                                                                this.USERNAME = rs2.getString(1);
                                                                this.EMAIL = rs2.getString(2);
                                                                this.PASS = rs2.getString(3);
                                                            }
                                                            if(this.USERNAME.equals(this.UserNameTextField.getText()) == true){
                                                                if(this.EMAIL.equalsIgnoreCase(this.EmailTextField.getText()) == true){
                                                                    if(this.PASS.equals(this.PasswordTextField.getText()) == true){
                                                            try {
                                                                Connection connection1 = DriverManager.getConnection(DB_URL, USER_NAME,
                                                                        PASSWORD);
                                                                Statement stmt12 = connection1.createStatement();
                                                                stmt12.executeUpdate("insert into Karaoke.SigninHis values('"+this.UserNameTextField.getText()+"', '"+this.EmailTextField.getText()+"','"+this.formatter.format(this.date)+"')");
                                                                connection.close();
                                                            } catch (Exception ex) {
                                                                ex.printStackTrace();
                                                            }
                                                        new InAppFrame(this.UserNameTextField.getText(), this.EmailTextField.getText());
                                                        this.SigninFrame.dispose();
                                                                }else{
                                                                    JOptionPane.showMessageDialog(null, "Wrong information !","Warning", JOptionPane.WARNING_MESSAGE);
                                                                }
                                                            }else{
                                                                JOptionPane.showMessageDialog(null, "Wrong information !","Warning", JOptionPane.WARNING_MESSAGE);
                                                            }
                                                        }else{
                                                            JOptionPane.showMessageDialog(null, "Wrong information !","Warning", JOptionPane.WARNING_MESSAGE);
                                                        }
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Wrong Password !",
                                                                "Warning", JOptionPane.WARNING_MESSAGE);
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null,
                                                            "Wrong Email, if you don't have account, make a new !",
                                                            "Warning",
                                                            JOptionPane.WARNING_MESSAGE);
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null,
                                                        "Wrong User name, if you don't have account, make a new !",
                                                        "Warning",
                                                        JOptionPane.WARNING_MESSAGE);
                                            }
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Password must be over than 7 charater !",
                                                "Warning !", JOptionPane.WARNING_MESSAGE);
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "Password cannot be null !!!", "Warning !",
                                            JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Email must contain '@' !", "Warning !",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong type of email !", "Warning !",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Email cannot be null !", "Warning !",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User name must be over than 7 charater !", "Warning !",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "User name cannot be null !", "Warning !",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
