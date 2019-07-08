import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyFirstServlet")

public class MyFirstServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;	
	private Hello hello = new Hello();
   
	//servlet ���o��Container�ҫإߪ���request&response
	//�ܩ�Container�p��h�M servlet �h������
	//�o�̴N�n��z�@�Uweb.xml
	//�]�N�O���ݴy�z��(Deployment Descriptor,²��DD)
	//Container�ǥѳo��DD�ӱo���p��h���� servlet ��JSP
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		request.getRequestDispatcher("login.jsp").forward(request, response);
		//forward��request.getRequestDispatcher�h���I�s
		//�o�̦��A�[�W�@��return;�N�����L�h�N���A����U����code�F
		//�ϥ�forward�ѩ󤺳��I�s,�bclient�W�ä��|�ݨ�{�����W��
		//�ӬO�bJSP���]�waction���W��
		
} 
    public void setMsg(String user){
    	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String name = request.getParameter("name"); //���o��login.jsp�W�Ҩ��o�ϥΪ̿�J���m�W�M�K�X
		String pwd = request.getParameter("mypassword");
		
	  	String secretPassword = hello.getPassword(name); //���o�ϥΪ̪��K�X
		
	  	//�n�J���T�ر��p 1. �ϥΪ̦s�b�A�B�K�X���T(�ɨ쥿�T�n�J����)
	  	//				 2. �ϥΪ̦s�b�A���K�X���~(�ɨ���~�����A��ܱK�X���~�T��)
	  	//				 3. �ϥΪ̤��s�b(�ɨ���~�����A��ܨϥΪ̤��s�b�T��)
	  	
	  	 if(hello.userIsExist(name))
	   	{
	  		if(secretPassword.equals(pwd)) //���p 1
	  		{
	  			String message = hello.doHello(name); //���ͭӧO�ϥΪ̪��w��T��
	  			request.setAttribute("message",message); //request.setAttribute(���w�n�ǵ�����H�W�r�A�ǤJ���Ѽ�)
	  			request.setAttribute("name",name);
	  			request.getRequestDispatcher("IIndex.jsp").forward(request, response);
	  			return;
	  		}
	  		else //���p 2
	  		{
		  		request.setAttribute("message","�K�X���~");
		  		request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
		  		return;	  			
	  		}
	   	}
	  	 else //���p3
	  	 {
		  	request.setAttribute("message","�ϥΪ̤��s�b");
		  	request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
		  	return;
	  	 }
	}

}
