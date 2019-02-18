package com.bishe.beautyProServer.Controller;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.mail.internet.MimeMessage.RecipientType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/validate/email",method= {RequestMethod.POST})
	public String sendByEmail(String username,HttpSession httpSession,HttpServletResponse response,HttpServletRequest request){
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
		int ran = (int)(Math.random()*(9999-1000+1))+1000;//产生1000-9999的随机数
		//设置邮件的文本内容
        String context = "验证码：%d，如非本人操作请忽略本短信。";
        context = String.format(context,ran);
        Transport transport;
		try {
			msg.setFrom(new InternetAddress(sendUser));
			msg.setSubject("琦色美妆验证码");//设置主题（标题）
			msg.addRecipients(RecipientType.TO, username);//设置多个收信人
			msg.setContent(context,"text/html;charset=utf-8");
			transport = session.getTransport();
			transport.connect(sendHost, sendUser, sendPass);
			transport.sendMessage(msg, msg.getAllRecipients());
			httpSession.setAttribute("emailValidateCode", ran);
			return "验证码已发往您的邮箱";
		} catch (MessagingException e) {
			e.printStackTrace();
			return "验证码发送失败,邮箱填写错误";
		}
		
	}
}
