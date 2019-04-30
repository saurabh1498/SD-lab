package customer;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
public class SMail
{
	public void sendMail(String too,String otp)
	{
		 try
		{
       			String host ="smtp.gmail.com" ;
      			String user = "";
        			String pass = "";     
       			String to = "ashok781998@gmail.com";
       			to=too;
       			String from = "rahul781998@gmail.com";          
 	 		String subject = "This is OTP for authentication.";    
     	   		String messageText = "OTP :"+otp;  
        	  		boolean sessionDebug = false;
         
			Properties props = System.getProperties();
        			props.put("mail.smtp.starttls.enable", "true");
  			props.put("mail.smtp.host", host);       
    	 		props.put("mail.smtp.port", "587");
      			props.put("mail.smtp.auth", "true");        
   	 		props.put("mail.smtp.starttls.required", "true");
			
			java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
      
     	 		Session mailSession = Session.getDefaultInstance(props, null);     
       			mailSession.setDebug(sessionDebug);     
     	 		Message msg = new MimeMessage(mailSession);
     	 		msg.setFrom(new InternetAddress(from));
   	 		InternetAddress[] address = {new InternetAddress(to)};    
      	  		msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject); msg.setSentDate(new Date());      
   	  	 	msg.setText(messageText);

       			Transport transport=mailSession.getTransport("smtp");
      	  		transport.connect(host, user, pass);     
    	 		transport.sendMessage(msg, msg.getAllRecipients());    
    	  		transport.close();
     
    			JOptionPane.showMessageDialog(null, "message send successfully");
     
  		 }
		catch(Exception ex)
      		{
          		  	System.out.println(ex);
       		}
	}
}
	