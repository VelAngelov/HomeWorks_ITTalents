package send_email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TestEmails {
	public static void main(String[] args) {
		String to = "vel.angelov@gmail.com";
		String from ="vel.angelov@gmail.com";
		String host ="localhost";
		
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host",host);
		Session session = Session.getDefaultInstance(properties);
		
		try {
			MimeMessage messege = new MimeMessage(session);
			System.out.println(1);
			messege.setFrom(new InternetAddress(from));
			System.out.println(2);
			messege.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			System.out.println(3);
			messege.setSubject("TestMessege");
			System.out.println(4);
			messege.setText("Proba na mailite ot java");
			System.out.println(5);
			
			Transport.send(messege);
			System.out.println("Send!");
		}catch(MessagingException e) {
			System.out.println("Error on sending!");
			 e.printStackTrace();
		}
	}
}
