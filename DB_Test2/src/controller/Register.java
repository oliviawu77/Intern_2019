package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBController db = new DBController();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");

		if(db.AccExists(request.getParameter("acc")))
		{
	  		request.setAttribute("message","±b¤á¤w¦s¦b");
	  		request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);			
		}
		else {
		db.CreateUser(request.getParameter("acc"),request.getParameter("pwd"),request.getParameter("mail"),request.getParameter("sex"),request.getParameter("age"),request.getParameter("name"));
		response.sendRedirect("Login.jsp");
		}
	}

}
