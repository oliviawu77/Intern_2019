

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ChangeMsg")
public class ChangeMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChangeMsg() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Msg = request.getParameter("welcomeMsg"); //取得使用者想要更改成的歡迎訊息
	}

}
