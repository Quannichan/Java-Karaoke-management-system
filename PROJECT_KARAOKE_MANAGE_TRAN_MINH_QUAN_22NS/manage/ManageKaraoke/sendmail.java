package ManageKaraoke;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class sendmail {
    int n;
    boolean get;

    public sendmail(String mail) {
        Random rand = new Random();
        int n = rand.nextInt(1000) * 100 + rand.nextInt(99);
        this.n = n;
        final String username = "tranminhquan130804@gmail.com";
        final String password = "";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("tranminhquan130804@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mail));
            message.setSubject("verification");
            message.setText("your verification codes :\n " + n
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");
            this.get = true;
        } catch (MessagingException e) {
            this.get = false;
        }
    }

}