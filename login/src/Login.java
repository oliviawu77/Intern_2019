import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(
    urlPatterns = {"/login"},
    initParams = {
        @WebInitParam(name = "SUCCESS", value = "user"),
        @WebInitParam(name = "ERROR", value = "login.html")
    }
)
public class Login extends HttpServlet {
    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        super.init();
        SUCCESS_VIEW = this.getInitParameter("SUCCESS");
        ERROR_VIEW = this.getInitParameter("ERROR");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                      throws ServletException, IOException {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        if("caterpillar".equals(name) && "123456".equals(passwd)) {
            request.changeSessionId();
            request.getSession().setAttribute("login", name);
            response.sendRedirect(SUCCESS_VIEW);
        }
        else {
            response.sendRedirect(ERROR_VIEW);
        }
    }
    
    @Override
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
