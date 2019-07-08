import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet(name="login", urlPatterns={"/login"},
loadOnStartup=1)

public class Login extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	//JSP��J���b���K�X
	  	String name = request.getParameter("name");
	  	String password= request.getParameter("mypassword");

	  	//init-paramn�ҳ]�w���b���K�X
	  	String secretName = getServletConfig().getInitParameter("name");
	  	String secretPassword = getInitParameter("password");
	  	 if(secretName.equals(name) && secretPassword.equals(password) )
	   	{
	   		request.setAttribute("myname",name);
	   		request.getRequestDispatcher("index.jsp").forward(request, response);
	   		return;
	   	}
	   	else
	   	{
	   		//�]�i�H�bServlet���Xcontext-param,�A��JSP���X
	   		//request.setAttribute("strMsg",strError);
	   		request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);	  	
	   	}
	}
} 