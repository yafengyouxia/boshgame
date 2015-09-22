package com.zsyj.fee.common.mail;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 简单邮件（不带附件的邮件）发送器
 */
public class SimpleMailSender {
	
	/**
	 * key:title value:inteval
	 * */
	private static Map<String, Date> mailInteval = new HashMap<String, Date>(); 
	
	/**
	 * 
	 * @param toAddress
	 * @param title
	 * @param content
	 * @param minuteInteval 发送邮件的间隔时间
	 */
	public void sendMail( String toAddress, String title, String content, int minuteInteval )
	{
		String hitorySend = title+toAddress;
		//minuteInteval 间隔时间多长不发送短信，避免短信骚扰
		if( minuteInteval > 0 )
		{
			if( mailInteval.get( hitorySend ) == null )
			{
				mailInteval.put( hitorySend, new Date() );
			}
			else
			{
				Date lastTime = mailInteval.get(hitorySend);
				Date currentTime = new Date();
				
				if( ( currentTime.getTime() - lastTime.getTime() ) < minuteInteval*60*1000 )
				{
					return;
				}
			}
			
			mailInteval.put( hitorySend , new Date() );
		}
		
		try{
			// 这个类主要是设置邮件
			MailSenderInfo mailInfo = MailSenderInfo.getInstance();
			
			mailInfo.setToAddress( toAddress );
			mailInfo.setSubject( title );
			mailInfo.setContent( content );
			
			// 这个类主要来发送邮件
			SimpleMailSender sms = new SimpleMailSender();
			sms.sendTextMail(mailInfo);
			//sms.sendHtmlMail(mailInfo);// 发送html格式
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 以文本格式发送邮件
	 * 
	 * @param mailInfo 待发送的邮件的信息
	 */
	public boolean sendTextMail(MailSenderInfo mailInfo) {
		// 判断是否需要身份认证
		MyAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// 如果需要身份认证，则创建一个密码验证器
			authenticator = new MyAuthenticator(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getInstance(pro, authenticator);
//				.getDefaultInstance(pro, authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			Address to = new InternetAddress(mailInfo.getToAddress());
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// 设置邮件消息的主题
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// 设置邮件消息的主要内容
			String mailContent = mailInfo.getContent();
			mailMessage.setText(mailContent);
			// 发送邮件
			Transport.send(mailMessage);
			return true;
		} catch ( Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * 以HTML格式发送邮件
	 * 
	 * @param mailInfo  待发送的邮件信息
	 */
	public static boolean sendHtmlMail(MailSenderInfo mailInfo) {
		
		try {
			
			// 判断是否需要身份认证
			MyAuthenticator authenticator = null;
			Properties pro = mailInfo.getProperties();
			// 如果需要身份认证，则创建一个密码验证器
			if (mailInfo.isValidate()) {
				authenticator = new MyAuthenticator(mailInfo.getUserName(),
						mailInfo.getPassword());
			}
			// 根据邮件会话属性和密码验证器构造一个发送邮件的session
			Session sendMailSession = Session.getInstance(pro, authenticator);
					//.getDefaultInstance(pro, authenticator);
			
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			Address to = new InternetAddress(mailInfo.getToAddress());
			// Message.RecipientType.TO属性表示接收者的类型为TO
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// 设置邮件消息的主题
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			// 设置HTML内容
			html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			// 将MiniMultipart对象设置为邮件内容
			mailMessage.setContent(mainPart);
			// 发送邮件
			Transport.send(mailMessage);
			return true;
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}
		return false;
	}

	public static void main(String args[]) {
		
		try
		{
			// 这个类主要是设置邮件
			MailSenderInfo mailInfo = MailSenderInfo.getInstance();
			
			//13922820502@139.com  李十子
			//13922820373@139.com  谭颖骞
			mailInfo.setToAddress("15899756538@139.com");
			mailInfo.setSubject("WARN");
			mailInfo.setContent("TestContent,收到请回答 by hj!");
			
			// 这个类主要来发送邮件
			SimpleMailSender sms = new SimpleMailSender();
//			sms.sendHtmlMail(mailInfo);// 发送html格式
			sms.sendTextMail(mailInfo);// 发送文体格式
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
}
