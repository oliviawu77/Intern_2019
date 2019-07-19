package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBController db = new DBController();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String msg = request.getParameter("msg");
		String mail = request.getParameter("mail");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		HttpSession session = request.getSession();
		String acc = (String) session.getAttribute("name");
		db.UpdateUser(acc,name,pwd,msg,mail,sex,age);
		response.sendRedirect("Index.jsp");		
	}

}
