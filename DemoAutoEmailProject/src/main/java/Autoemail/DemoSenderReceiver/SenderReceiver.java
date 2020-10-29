package Autoemail.DemoSenderReceiver;
import javax.mail.MessagingException;

import Autoemail.DemoAutoEmailProject.*;

public class SenderReceiver {
	public static void main(String[] args) throws MessagingException {
	    
	    //String to[] = {"test02@gmail.com","test03@gmail.com"};
		
	    String to[] = {"testing20201011@yahoo.com"};
	    //String from[] = {"testing20201011@gmail.com"};
	    
	      
	    
	    SendEmail.send("testing20201011@gmail.com", to, "testing20201011@gmail.com testing20201011@yahoo.com", "");
	  }
}
