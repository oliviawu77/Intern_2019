package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBController db = new DBController();       

    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd_new = request.getParameter("pwd_new");
		HttpSession session = request.getSession();
		String acc = (String) session.getAttribute("name");
		System.out.println(acc);
		db.changePwd(acc, pwd_new);
		response.sendRedirect("IIndex.jsp");
		//request.getRequestDispatcher("IIndex.jsp").forward(request, response);
	}

}
