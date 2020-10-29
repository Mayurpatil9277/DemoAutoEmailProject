package Autoemail.DemoAutoEmailProject;


import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendEmail {

  public static void send(String from, String tos[], String subject,
      String text) throws MessagingException {
    // Get the session object
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class",
        "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    Session session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(
            "testing20201011@gmail.com",
            "dell@123");// change accordingly
          }
        });

    // compose message
    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));// change accordingly
      for (String to : tos) {
        message.addRecipient(Message.RecipientType.TO,
            new InternetAddress(to));
      }
      /*
       * for (String cc : ccs)
       * message.addRecipient(Message.RecipientType.CC,new
       * InternetAddress(cc));
       */
     /* StringBuilder str1= new StringBuilder(); 
      str1.append(from); 
      System.out.println("String = "+ str1.toString());
      
      StringBuilder str2= new StringBuilder(); 
      str2.append(tos); 
      System.out.println("String = "+ str2.toString()); 
      StringBuilder sb = new StringBuilder(str1);
      //Concatenating the two Strings
      sb.append(str2);
      System.out.println(sb);*/
      
      message.setSubject(subject);
      
      String filename = "D:\\attachment.txt";

      BodyPart objMessageBodyPart = new MimeBodyPart();
     
      objMessageBodyPart.setContent(
          "Lorem................................" + text, "text/html");
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(objMessageBodyPart);

      objMessageBodyPart = new MimeBodyPart();
      DataSource source = new FileDataSource(filename);
      objMessageBodyPart.setDataHandler(new DataHandler(source));
      objMessageBodyPart.setFileName(filename);
      multipart.addBodyPart(objMessageBodyPart);
      message.setContent(multipart);

    
      Transport.send(message);

      System.out.println("message sent successfully");

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }
}