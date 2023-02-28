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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class forgetPU extends conmysql implements ActionListener {
    JFrame ForgerPUFrame;
    JButton BackButton, NextButton, resend, BackButton2, NextButton2, BackButton3, NextButton3;
    JTextArea FAWMText, WIYE, PleaseCheckText, VerificateCodeText, ResetPassText, PassText, ConfirmPassText;
    JTextField EmailTextField, passcode;
    JPasswordField Password, ConfirmPassword;
    int code;
    JCheckBox showpass;
    JLabel LableEmail, PasscodeLabel, newPasslabel;
    int choosen;
    ImageIcon imageIcon = new ImageIcon("icon.jpg");
    Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
    ImageIcon question = new ImageIcon("question.png");
    ArrayList<String> Email = new ArrayList<String>();
    ArrayList<String> UN = new ArrayList<String>();

    public forgetPU() {

        FAWMText = new JTextArea("Find account with email");
        FAWMText.setEditable(false);
        FAWMText.setFocusable(false);
        FAWMText.setBounds(110, 35, 400, 40);
        FAWMText.setFont(new Font("Serif", Font.BOLD, 35));

        WIYE = new JTextArea("What's your email?");
        WIYE.setEditable(false);
        WIYE.setFocusable(false);
        WIYE.setBounds(25, 110, 155, 25);
        WIYE.setFont(new Font("Serif", Font.BOLD, 18));

        EmailTextField = new JTextField();
        EmailTextField.setBounds(200, 110, 320, 30);
        EmailTextField.setFont(new Font("Serif", Font.BOLD, 18));
        EmailTextField.setBorder(border);

        BackButton = new JButton("Back");
        BackButton.setBounds(30, 165, 90, 30);
        BackButton.setFont(new Font("Serif", Font.BOLD, 18));
        BackButton.setFocusable(false);
        BackButton.addActionListener(this);

        NextButton = new JButton("Next");
        NextButton.setBounds(465, 165, 90, 30);
        NextButton.setFont(new Font("Serif", Font.BOLD, 18));
        NextButton.setFocusable(false);
        NextButton.addActionListener(this);

        LableEmail = new JLabel();
        LableEmail.setSize(600, 250);
        LableEmail.setBackground(Color.WHITE);
        LableEmail.setOpaque(true);
        LableEmail.add(EmailTextField);
        LableEmail.add(FAWMText);
        LableEmail.add(WIYE);
        LableEmail.add(BackButton);
        LableEmail.add(NextButton);

        PleaseCheckText = new JTextArea("Verificate code has been sent to your email, please check!");
        PleaseCheckText.setEditable(false);
        PleaseCheckText.setFocusable(false);
        PleaseCheckText.setBounds(60, 35, 500, 30);
        PleaseCheckText.setFont(new Font("Serif", Font.BOLD, 20));

        VerificateCodeText = new JTextArea("Verificate code");
        VerificateCodeText.setEditable(false);
        VerificateCodeText.setFocusable(false);
        VerificateCodeText.setBounds(50, 110, 140, 25);
        VerificateCodeText.setFont(new Font("Serif", Font.BOLD, 18));

        passcode = new JTextField();
        passcode.setBounds(190, 110, 200, 30);
        passcode.setFont(new Font("Serif", Font.BOLD, 18));
        passcode.setBorder(border);

        BackButton2 = new JButton("Back");
        BackButton2.setBounds(30, 165, 90, 30);
        BackButton2.setFont(new Font("Serif", Font.BOLD, 18));
        BackButton2.setFocusable(false);
        BackButton2.addActionListener(this);

        resend = new JButton("Resend code");
        resend.setBounds(420, 110, 150, 30);
        resend.setFont(new Font("Serif", Font.BOLD, 18));
        resend.setFocusable(false);
        resend.addActionListener(this);

        NextButton2 = new JButton("Next");
        NextButton2.setBounds(465, 165, 90, 30);
        NextButton2.setFont(new Font("Serif", Font.BOLD, 18));
        NextButton2.setFocusable(false);
        NextButton2.addActionListener(this);

        PasscodeLabel = new JLabel();
        PasscodeLabel.setSize(600, 250);
        PasscodeLabel.setBackground(Color.WHITE);
        PasscodeLabel.setOpaque(true);
        PasscodeLabel.setVisible(false);
        PasscodeLabel.add(VerificateCodeText);
        PasscodeLabel.add(PleaseCheckText);
        PasscodeLabel.add(passcode);
        PasscodeLabel.add(resend);
        PasscodeLabel.add(BackButton2);
        PasscodeLabel.add(NextButton2);

        ResetPassText = new JTextArea("Reset password");
        ResetPassText.setEditable(false);
        ResetPassText.setFocusable(false);
        ResetPassText.setBounds(175, 12, 400, 45);
        ResetPassText.setFont(new Font("Serif", Font.BOLD, 35));

        PassText = new JTextArea("Password");
        PassText.setEditable(false);
        PassText.setFocusable(false);
        PassText.setBounds(23, 65, 95, 25);
        PassText.setFont(new Font("Serif", Font.BOLD, 20));

        ConfirmPassText = new JTextArea("Confirm\npassword");
        ConfirmPassText.setEditable(false);
        ConfirmPassText.setFocusable(false);
        ConfirmPassText.setBounds(23, 100, 96, 65);
        ConfirmPassText.setFont(new Font("Serif", Font.BOLD, 20));

        Password = new JPasswordField();
        Password.setBounds(130, 64, 400, 30);
        Password.setFont(new Font("Serif", Font.BOLD, 18));
        Password.setBorder(border);

        ConfirmPassword = new JPasswordField();
        ConfirmPassword.setBounds(130, 111, 400, 30);
        ConfirmPassword.setFont(new Font("Serif", Font.BOLD, 18));
        ConfirmPassword.setBorder(border);

        BackButton3 = new JButton("Back");
        BackButton3.setBounds(30, 165, 90, 30);
        BackButton3.setFont(new Font("Serif", Font.BOLD, 18));
        BackButton3.setFocusable(false);
        BackButton3.addActionListener(this);

        NextButton3 = new JButton("Next");
        NextButton3.setBounds(465, 165, 90, 30);
        NextButton3.setFont(new Font("Serif", Font.BOLD, 18));
        NextButton3.setFocusable(false);
        NextButton3.addActionListener(this);

        showpass = new JCheckBox("Show password");
        showpass.setBounds(130, 155, 150, 30);
        showpass.setBackground(Color.WHITE);
        showpass.setOpaque(true);
        showpass.setFocusable(false);
        showpass.addActionListener(this);

        newPasslabel = new JLabel();
        newPasslabel.setSize(600, 250);
        newPasslabel.setBackground(Color.WHITE);
        newPasslabel.setOpaque(true);
        newPasslabel.setVisible(false);
        newPasslabel.add(ResetPassText);
        newPasslabel.add(PassText);
        newPasslabel.add(ConfirmPassText);
        newPasslabel.add(Password);
        newPasslabel.add(ConfirmPassword);
        newPasslabel.add(BackButton3);
        newPasslabel.add(NextButton3);
        newPasslabel.add(showpass);

        ForgerPUFrame = new JFrame("Find Information");
        ForgerPUFrame.setSize(600, 250);
        ForgerPUFrame.setIconImage(imageIcon.getImage());
        ForgerPUFrame.setVisible(true);
        ForgerPUFrame.setLocationRelativeTo(null);
        ForgerPUFrame.setLayout(null);
        ForgerPUFrame.setResizable(false);
        ForgerPUFrame.add(LableEmail);
        ForgerPUFrame.add(PasscodeLabel);
        ForgerPUFrame.add(newPasslabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BackButton) {
            this.ForgerPUFrame.dispose();
        } else {

        }

        if (e.getSource() == BackButton2) {
            this.LableEmail.setVisible(true);
            this.PasscodeLabel.setVisible(false);
        } else {

        }

        if (e.getSource() == resend) {
            sendmail sendmail = new sendmail(EmailTextField.getText());
            if (sendmail.get == true) {
                this.code = sendmail.n;
                JOptionPane.showMessageDialog(null, "Verificate code sent successful!",
                        "Sent success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Verificate code cannot resend!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
        }

        if (e.getSource() == NextButton) {
            if (EmailTextField.getText().length() != 0) {
                CheckEmail check = new CheckEmail();
                if (check.CheckEmail(EmailTextField.getText()) == true) {
                    try {
                        Connection connection = DriverManager.getConnection(DB_URL, USER_NAME,
                                PASSWORD);
                        Statement stmt = connection.createStatement();
                        ResultSet rs = stmt
                                .executeQuery(
                                        "Select UserName,Email from Karaoke.UserList");
                        while (rs.next()) {
                            UN.add(rs.getString(1));
                            Email.add(rs.getString(2));
                        }
                        connection.close();
                        if (Email.contains(EmailTextField.getText())) {
                            String choose[] = { "User Name", "Password" };
                            choosen = JOptionPane.showOptionDialog(null,
                                    "What do you want to find ?",
                                    "find information", JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, question, choose, 0);
                            if (choosen == 0) {
                                sendmail sendmail = new sendmail(EmailTextField.getText());
                                if (sendmail.get == true) {
                                    this.code = sendmail.n;
                                    this.LableEmail.setVisible(false);
                                    this.PasscodeLabel.setVisible(true);

                                } else {
                                    JOptionPane.showMessageDialog(null, "Verificate code cannot be sent!",
                                            "Warning",
                                            JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                sendmail sendmail = new sendmail(EmailTextField.getText());
                                if (sendmail.get == true) {
                                    this.code = sendmail.n;
                                    this.LableEmail.setVisible(false);
                                    this.PasscodeLabel.setVisible(true);

                                } else {
                                    JOptionPane.showMessageDialog(null, "Verificate code cannot be sent!",
                                            "Warning",
                                            JOptionPane.WARNING_MESSAGE);
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Your email not exist, please create new account!",
                                    "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid email !",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Email box can't be null !",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }

        } else {
        }

        if (e.getSource() == NextButton2) {
            if (passcode.getText().length() != 0) {
                if (passcode.getText().equals(Integer.toString(this.code))) {
                    if (choosen == 0) {
                        this.ForgerPUFrame.dispose();
                        JOptionPane.showMessageDialog(null,
                                "Your username is " + UN.get(Email.indexOf(EmailTextField.getText())),
                                "Find information",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        this.PasscodeLabel.setVisible(false);
                        this.newPasslabel.setVisible(true);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong verificate code!",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please input verificate code!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == BackButton3) {
            this.passcode.setText(null);
            this.Password.setText(null);
            this.ConfirmPassword.setText(null);
            this.newPasslabel.setVisible(false);
            this.LableEmail.setVisible(true);

        } else {

        }

        if (e.getSource() == NextButton3) {
            if (this.Password.getText().length() != 0) {
                if (this.Password.getText().length() >= 7) {
                    if (this.ConfirmPassword.getText().length() != 0) {
                        if (this.ConfirmPassword.getText().equals(this.Password.getText()) == true) {
                            try {
                                Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                                Statement stmt = connection.createStatement();
                                stmt.executeUpdate(
                                        "Update Karaoke.UserList\nSet Pass = aes_encrypt('"
                                                + this.ConfirmPassword.getText() + "','key123')\nwhere Email = '"
                                                + this.EmailTextField.getText()
                                                + "';");
                                connection.close();
                                this.ForgerPUFrame.dispose();
                                ;
                                JOptionPane.showMessageDialog(null, "Your password has been reset successful!",
                                        "Yayy", JOptionPane.INFORMATION_MESSAGE);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Your password cannot be reset!", "Warning",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Confirm password is not same the password!",
                                    "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please confirm password!", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password must be over than 7 character!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password cannot be null!", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
        }

        if (showpass.isSelected()) {
            Password.setEchoChar((char) 0);
            ConfirmPassword.setEchoChar((char) 0);
        } else {
            Password.setEchoChar('*');
            ConfirmPassword.setEchoChar('*');
        }

    }
}
