package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DBController db = new DBController();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		request.getRequestDispatcher("UI.jsp").forward(request, response);

} 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String name = request.getParameter("acc"); //���o��UI.jsp�W�Ҩ��o�ϥΪ̿�J���m�W�M�K�X
		String pwd = request.getParameter("pwd");
		String Pwd_valid = db.getPwd(name);
	  	//�n�J���T�ر��p 1. �ϥΪ̦s�b�A�B�K�X���T(�ɨ쥿�T�n�J����)
	  	//				 2. �ϥΪ̦s�b�A���K�X���~(�ɨ���~�����A��ܱK�X���~�T��)
	  	//				 3. �ϥΪ̤��s�b(�ɨ���~�����A��ܨϥΪ̤��s�b�T��)
		request.getRequestDispatcher("IIndex.jsp").forward(request, response);
	  	/*
	  	 if( Pwd_valid != null )
	   	{
	  		if(Pwd_valid.equals(pwd)) //���p 1
	  		{
	  			String message = "helloworld!"; //���ͭӧO�ϥΪ̪��w��T��
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
	}*/

}
