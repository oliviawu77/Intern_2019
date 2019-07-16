package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangeMessage
 */
@WebServlet("/ChangeMessage")
public class ChangeMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBController db = new DBController();        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeMessage() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("msg_new"));
		String msg_new = request.getParameter("msg_new");
		System.out.println(msg_new);
		HttpSession session = request.getSession();
		String acc = (String) session.getAttribute("name");
		db.changeMsg(acc, msg_new);
		
		request.getRequestDispatcher("IIndex.jsp").forward(request, response);
	}

}
