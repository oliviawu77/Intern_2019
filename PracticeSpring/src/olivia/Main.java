package olivia;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("RoleBean.xml");
		Role role = (Role) context.getBean("role");
		System.out.println("¨¤¦â¦W¡@= " + role.getName());
		role.shoot();
	}

}
