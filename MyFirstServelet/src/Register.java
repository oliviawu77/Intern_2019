

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
    private Hello newRegister = new Hello();   

    public Register() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name"); //���o��login.jsp�W�Ҩ��o�ϥΪ̿�J���m�W�M�K�X
		String pwd = request.getParameter("mypassword");
		String msg = request.getParameter("welmsg");
		newRegister.register(name, pwd, msg);
		//request.getRequestDispatcher("login.jsp").forward(request, response);
		response.sendRedirect("MyFirstServlet");


	}

}
