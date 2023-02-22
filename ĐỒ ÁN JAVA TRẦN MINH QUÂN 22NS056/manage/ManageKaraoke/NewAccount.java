package ManageKaraoke;

import java.awt.Color;
import java.awt.Font;

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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class NewAccount extends conmysql implements ActionListener {
    JFrame NewAccountFrame, SendEmailFrame;
    JButton BackButton, NextButton, BackButton2, ResendCodeButton, NextButton2;
    JTextArea UserNameText, EmailText, PassWordText, ConfirmPassText, CodeSentText, CodeText;
    JLabel NewAccountLable, ImageLabel, VerificateCodeLabel;
    JTextField UserNameTextField, EmailTextField, textcode;
    JPasswordField PassWordTextField, ConfirmPassTextField;
    JCheckBox show, show1;
    String username, mail, pass;
    CheckEmail check = new CheckEmail();
    Border border = BorderFactory.createLineBorder(Color.black);
    ImageIcon imageIcon = new ImageIcon("image.jpg");
    ImageIcon iconn = new ImageIcon("alert.gif");
    ImageIcon icon = new ImageIcon("icon.jpg");
    SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    Date date = new Date();
    int code;

    public NewAccount() {

        this.UserNameText = new JTextArea();
        this.UserNameText.setText("Username");
        this.UserNameText.setBounds(20, 125, 90, 20);
        this.UserNameText.setFont(new Font("Serif", Font.BOLD, 18));
        this.UserNameText.setEditable(false);

        this.EmailText = new JTextArea();
        this.EmailText.setText("Email");
        this.EmailText.setBounds(20, 160, 90, 20);
        this.EmailText.setFont(new Font("Serif", Font.BOLD, 18));
        this.EmailText.setEditable(false);

        this.PassWordText = new JTextArea();
        this.PassWordText.setText("Password");
        this.PassWordText.setBounds(20, 195, 100, 20);
        this.PassWordText.setFont(new Font("Serif", Font.BOLD, 18));
        this.PassWordText.setEditable(false);

        this.ConfirmPassText = new JTextArea();
        this.ConfirmPassText.setText("Confirm\nPassword");
        this.ConfirmPassText.setBounds(20, 230, 90, 50);
        this.ConfirmPassText.setFont(new Font("Serif", Font.BOLD, 18));
        this.ConfirmPassText.setEditable(false);

        this.BackButton = new JButton("Back");
        this.BackButton.setBounds(80, 320, 80, 30);
        this.BackButton.setFocusable(false);
        this.BackButton.setFont(new Font("Serif", Font.BOLD, 18));
        this.BackButton.addActionListener(this);

        this.NextButton = new JButton("Next");
        this.NextButton.setBounds(320, 320, 70, 30);
        this.NextButton.setFocusable(false);
        this.NextButton.setFont(new Font("Serif", Font.BOLD, 18));
        this.NextButton.addActionListener(this);

        this.UserNameTextField = new JTextField();
        this.UserNameTextField.setBounds(120, 128, 302, 24);
        this.UserNameTextField.setBorder(this.border);
        this.UserNameTextField.setFont(new Font("Serif", Font.BOLD, 18));

        this.EmailTextField = new JTextField();
        this.EmailTextField.setBounds(120, 163, 302, 24);
        this.EmailTextField.setBorder(this.border);
        this.EmailTextField.setFont(new Font("Serif", Font.BOLD, 18));

        this.PassWordTextField = new JPasswordField();
        this.PassWordTextField.setBounds(120, 198, 302, 24);
        this.PassWordTextField.setBorder(this.border);
        this.PassWordTextField.setFont(new Font("Serif", Font.BOLD, 18));

        this.ConfirmPassTextField = new JPasswordField();
        this.ConfirmPassTextField.setBounds(120, 239, 302, 24);
        this.ConfirmPassTextField.setBorder(this.border);
        this.ConfirmPassTextField.setFont(new Font("Serif", Font.BOLD, 18));

        this.show = new JCheckBox("Show password");
        this.show.setBounds(118, 265, 150, 30);
        this.show.setBackground(Color.WHITE);
        this.show.setOpaque(true);
        this.show.setFocusable(false);
        this.show.addActionListener(this);

        this.ImageLabel = new JLabel();
        this.ImageLabel.setText("Sign up");
        this.ImageLabel.setFont(new Font("Serif", Font.BOLD, 40));
        this.ImageLabel.setForeground(Color.WHITE);
        this.ImageLabel.setIcon(this.imageIcon);
        this.ImageLabel.setSize(500, 100);
        this.ImageLabel.setVerticalTextPosition(JLabel.CENTER);
        this.ImageLabel.setHorizontalTextPosition(JLabel.CENTER);

        this.NewAccountLable = new JLabel();
        this.NewAccountLable.setSize(500, 410);
        this.NewAccountLable.setBackground(Color.WHITE);
        this.NewAccountLable.setOpaque(true);
        this.NewAccountLable.add(this.UserNameText);
        this.NewAccountLable.add(this.EmailText);
        this.NewAccountLable.add(this.PassWordText);
        this.NewAccountLable.add(this.ConfirmPassText);
        this.NewAccountLable.add(this.BackButton);
        this.NewAccountLable.add(this.NextButton);
        this.NewAccountLable.add(this.UserNameTextField);
        this.NewAccountLable.add(this.EmailTextField);
        this.NewAccountLable.add(this.PassWordTextField);
        this.NewAccountLable.add(this.ConfirmPassTextField);
        this.NewAccountLable.add(this.show);
        this.NewAccountLable.add(this.ImageLabel);

        this.NewAccountFrame = new JFrame("New Account");
        this.NewAccountFrame.setIconImage(this.icon.getImage());
        this.NewAccountFrame.setSize(500, 410);
        this.NewAccountFrame.setLocationRelativeTo(null);
        this.NewAccountFrame.setLayout(null);
        this.NewAccountFrame.setVisible(true);
        this.NewAccountFrame.setResizable(false);
        this.NewAccountFrame.add(this.NewAccountLable);

        this.CodeSentText = new JTextArea("Varificate code sent");
        this.CodeSentText.setFont(new Font("Serif", Font.BOLD, 20));
        this.CodeSentText.setBounds(77, 20, 201, 23);
        this.CodeSentText.setFocusable(false);

        this.CodeText = new JTextArea("Varificate code");
        this.CodeText.setFont(new Font("Serif", Font.BOLD, 16));
        this.CodeText.setBounds(25, 75, 105, 20);
        this.CodeText.setFocusable(false);

        this.textcode = new JTextField();
        this.textcode.setBounds(150, 77, 150, 22);
        this.textcode.setFont(new Font("Serif", Font.BOLD, 19));
        this.textcode.setHorizontalAlignment(JTextField.CENTER);

        this.BackButton2 = new JButton("Back");
        this.BackButton2.setBounds(10, 135, 75, 20);
        this.BackButton2.setFont(new Font("Serif", Font.BOLD, 16));
        this.BackButton2.addActionListener(this);

        this.ResendCodeButton = new JButton("Resend Code");
        this.ResendCodeButton.setBounds(102, 135, 130, 20);
        this.ResendCodeButton.setFont(new Font("Serif", Font.BOLD, 16));
        this.ResendCodeButton.addActionListener(this);

        this.NextButton2 = new JButton("Next");
        this.NextButton2.setBounds(250, 135, 75, 20);
        this.NextButton2.setFont(new Font("Serif", Font.BOLD, 16));
        this.NextButton2.addActionListener(this);

        this.VerificateCodeLabel = new JLabel();
        this.VerificateCodeLabel.setSize(350, 210);
        this.VerificateCodeLabel.setBackground(Color.WHITE);
        this.VerificateCodeLabel.setOpaque(true);
        this.VerificateCodeLabel.add(this.CodeSentText);
        this.VerificateCodeLabel.add(this.CodeText);
        this.VerificateCodeLabel.add(this.BackButton2);
        this.VerificateCodeLabel.add(this.ResendCodeButton);
        this.VerificateCodeLabel.add(this.NextButton2);
        this.VerificateCodeLabel.add(this.textcode);

        this.SendEmailFrame = new JFrame("Varificate email");
        this.SendEmailFrame.setSize(350, 210);
        this.SendEmailFrame.setVisible(true);
        this.SendEmailFrame.setLocationRelativeTo(null);
        this.SendEmailFrame.setIconImage(this.icon.getImage());
        this.SendEmailFrame.add(this.VerificateCodeLabel);
        this.SendEmailFrame.setResizable(false);
        this.SendEmailFrame.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.BackButton) {
            this.NewAccountFrame.dispose();
        } else {
        }

        if (this.show.isSelected()) {
            this.PassWordTextField.setEchoChar((char) 0);
            this.ConfirmPassTextField.setEchoChar((char) 0);
        } else {
            this.PassWordTextField.setEchoChar('*');
            this.ConfirmPassTextField.setEchoChar('*');
        }

        if (e.getSource() == this.NextButton) {
            try {
                conmysql conn = new conmysql();
                Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(
                        "Select UserName, Email from Karaoke.UserList");
                ArrayList<String> UN = new ArrayList<String>();
                ArrayList<String> Email = new ArrayList<String>();
                while (rs.next()) {
                    UN.add(rs.getString(1));
                    Email.add(rs.getString(2));
                }
                connection.close();

                if (this.UserNameTextField.getText().length() != 0) {
                    if (this.UserNameTextField.getText().length() >= 7) {
                        if (this.UserNameTextField.getText().length() <= 22) {
                            if (UN.contains(this.UserNameTextField.getText()) != true) {
                                if (this.EmailTextField.getText().length() != 0) {
                                    if (this.check.CheckEmail(this.EmailTextField.getText()) == true) {
                                        if (Email.contains(this.EmailTextField.getText()) != true) {
                                            if (this.PassWordTextField.getText().length() != 0) {
                                                if (this.PassWordTextField.getText().length() >= 7) {
                                                    if (this.ConfirmPassTextField.getText().length() != 0) {
                                                        if (this.ConfirmPassTextField.getText()
                                                                .equals(this.PassWordTextField.getText()) == true) {
                                                            this.username = this.UserNameTextField.getText();
                                                            this.mail = this.EmailTextField.getText();
                                                            this.pass = this.PassWordTextField.getText();
                                                            String[] choose = { "No", "Yes" };
                                                            int choices = JOptionPane.showOptionDialog(null,
                                                                    "Sign in with this " + this.mail,
                                                                    "Warning!", JOptionPane.OK_CANCEL_OPTION,
                                                                    JOptionPane.WARNING_MESSAGE, this.iconn, choose, 0);
                                                            if (choices == 1) {
                                                                sendmail sm = new sendmail(this.mail);
                                                                if (sm.get == true) {
                                                                    this.code = sm.n;
                                                                    this.NewAccountFrame.setVisible(true);
                                                                    this.SendEmailFrame.setVisible(true);
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null,
                                                                            "Cannot send email!",
                                                                            "Warning!", JOptionPane.YES_NO_OPTION);
                                                                }
                                                            } else {
                                                            }

                                                        } else {
                                                            JOptionPane.showMessageDialog(null,
                                                                    "Password confirm is not match!",
                                                                    "Warning!", JOptionPane.YES_NO_OPTION);
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Please confirm password!",
                                                                "Warning!",
                                                                JOptionPane.YES_NO_OPTION);
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null,
                                                            "Password must be over than 7 character!",
                                                            "Warning!", JOptionPane.WARNING_MESSAGE);
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Password cannot be null!",
                                                        "Warning!",
                                                        JOptionPane.WARNING_MESSAGE);
                                            }
                                        } else {
                                            this.mail = this.EmailTextField.getText();
                                            String[] choosen = { "No", "Yes" };
                                            int chon = JOptionPane.showOptionDialog(null,
                                                    "Email already exist, do you wanna sign in with " + this.mail,
                                                    "Warning!", JOptionPane.OK_CANCEL_OPTION,
                                                    JOptionPane.WARNING_MESSAGE, this.iconn, choosen, 0);
                                            if (chon == 1) {
                                                this.NewAccountFrame.dispose();
                                            } else {

                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Invalid Email!", "Warning!",
                                                JOptionPane.WARNING_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Email cannot be null!", "Warning!",
                                            JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "User name already in use by other user!",
                                        "Warning!",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "User name is to long !", "Warning!",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "User name must be over than 7 character!",
                                "Warning!", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User name cannot be null!", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {

        }
        if (e.getSource() == this.BackButton2) {
            this.SendEmailFrame.dispose();
        } else {
        }

        if (e.getSource() == this.ResendCodeButton) {
            sendmail sm = new sendmail(this.mail);
            if (sm.get == true) {
                this.code = sm.n;
                JOptionPane.showMessageDialog(null, "Varidicate code has been resent!", "Resent success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Varidicate code cannot be resent!", "Resent failed",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
        }
        String getString = this.textcode.getText();
        String Code = Integer.toString(this.code);
        if (e.getSource() == this.NextButton2) {
            if (getString.equals(Code)) {
                try {
                    Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate(
                            "insert into Karaoke.UserList values('" + this.formatter.format(this.date) + "','"
                                    + this.username
                                    + "','" + this.mail + "',aes_encrypt('" + this.pass + "','key123'));");
                    connection.close();
                    this.SendEmailFrame.dispose();
                    this.NewAccountFrame.dispose();
                    JOptionPane.showMessageDialog(null, "Yayy!!! Your account has been create successful!",
                            "Congrtulation!!!", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cannot create new account!", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                if (this.textcode.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Please input varificate code!", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong varificate code!", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}