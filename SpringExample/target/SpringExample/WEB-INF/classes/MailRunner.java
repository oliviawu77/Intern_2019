package com;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class MailRunner {
 
	public static void main(String[] args) {
 
                //讀入AppContext-*.xml  (*在此為萬用字元，也就是說讀取所有AppContext-開頭的xml)
		ApplicationContext context = new ClassPathXmlApplicationContext("AppContext-*.xml");
                //從AppContext-*.xml 找尋Bean Id名稱為 【mailSend】的物件並注入 ms 中
		MailSend ms = (MailSend) context.getBean("mailSend");
 
                //arg = from , to , subject , content
		ms.sendMail("oliviawu77@gmail.com", "oliviawu77@gmail.com", "JavaMailTest", "Hello JavaMail");
 
	}
 
}