package com;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class MailRunner {
 
	public static void main(String[] args) {
 
                //Ū�JAppContext-*.xml  (*�b�����U�Φr���A�]�N�O��Ū���Ҧ�AppContext-�}�Y��xml)
		ApplicationContext context = new ClassPathXmlApplicationContext("AppContext-*.xml");
                //�qAppContext-*.xml ��MBean Id�W�٬� �imailSend�j������ê`�J ms ��
		MailSend ms = (MailSend) context.getBean("mailSend");
 
                //arg = from , to , subject , content
		ms.sendMail("oliviawu77@gmail.com", "oliviawu77@gmail.com", "JavaMailTest", "Hello JavaMail");
 
	}
 
}