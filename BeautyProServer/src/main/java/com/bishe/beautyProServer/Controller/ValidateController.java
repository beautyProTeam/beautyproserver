package com.bishe.beautyProServer.Controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/v1")
public class ValidateController {
	@Value("${sendUser}")
	private String sendUser;
	@Value("${sendPass}")
	private String sendPass;
	@Value("${sendMailHost}")
	private String sendHost;
	@Value("${transport.protocol}")
	private String protocol;
	
	/**发送验证码到邮箱进行验证
	 * @param username 邮箱验证码的目标用户
	 * @throws AddressException
	 * @throws MessagingException
	 */
	
	@RequestMapping(value="validate/email",method= {RequestMethod.POST})
	public String sendByEmail(String username){
		Properties props=new Properties();
		props.setProperty("mail.host", sendHost);
		props.setProperty("mail.transport.protocol", protocol);
		props.setProperty("mail.debug", "true");
		props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
	    props.setProperty("mail.smtp.socketFactory.port", "465");
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props);
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(sendUser));
			//设置发信人
			msg.addRecipients(RecipientType.TO, username);//设置多个收信人
			msg.setSubject("琦色美妆验证码");//设置主题（标题）
			int ran = (int)(Math.random()*(9999-1000+1))+1000;//产生1000-9999的随机数
			 //设置邮件的文本内容
	        String context = "验证码：%d，如非本人操作请忽略本短信。";
	        context = String.format(context,ran);
			msg.setContent(context,"text/html;charset=utf-8");
			MimeMultipart parts = new MimeMultipart();//多部件对象，可以理解为是部件的集合
			MimeBodyPart part2 = new MimeBodyPart();//创建一个部件
			Transport transport = session.getTransport();
			transport.connect(sendHost, sendUser, sendPass);
			transport.sendMessage(msg, msg.getAllRecipients());
			return "1";
		} catch (AddressException e) {
			e.printStackTrace();
			return "0";
		} catch (MessagingException e) {
			e.printStackTrace();
			return "0";
		}
		
	}
}
