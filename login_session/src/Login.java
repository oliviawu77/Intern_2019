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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		request.getRequestDispatcher("login.html").forward(request, response);
} 	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                      throws ServletException, IOException {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        if("Olivia".equals(name) && "123456".equals(passwd)) {
            if(request.getSession(false) != null) {
                changeSessionId(request); //基於 Web 安全考量，建議在登入成功後改變 Session ID
            }               
            request.getSession().setAttribute("login", name);
            response.sendRedirect("user");
        }
        else {
            response.sendRedirect("login");
        }
    }

    private void changeSessionId(HttpServletRequest request) {
        HttpSession oldSession = request.getSession();

        Map<String, Object> attrs = new HashMap<>();
        for(String name : Collections.list(oldSession.getAttributeNames())) {
            attrs.put(name, oldSession.getAttribute(name));
            oldSession.removeAttribute(name);
        }
        oldSession.invalidate(); // 令目前 Session 失效

        HttpSession newSession = request.getSession(); 
        for(String name : attrs.keySet()) {
            newSession.setAttribute(name, attrs.get(name));
        }
    }
} 