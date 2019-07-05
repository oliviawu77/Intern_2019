import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/questionnaire")
public class Questionnaire extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
                      throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("</head>");
        out.println("<body>");

        String page = request.getParameter("page");
        out.println("<form action='questionnaire' method='post'>");

        if("page1".equals(page)) {          // �Ĥ@���ݨ�
            out.println("���D�@�G<input type='text' name='p1q1'><br>");
            out.println("���D�G�G<input type='text' name='p1q2'><br>");
            out.println("<input type='submit' name='page' value='page2'>");
        } //�w�]�b�����s�����e�A�Ҩ��o�� HttpSession ���O�ۦP�����
        else if("page2".equals(page)) {    // �ĤG���ݨ�
            String p1q1 = request.getParameter("p1q1"); 
            String p1q2 = request.getParameter("p1q2");
            request.getSession().setAttribute("p1q1", p1q1);
            request.getSession().setAttribute("p1q2", p1q2);
            out.println("���D�T�G<input type='text' name='p2q1'><br>");
            out.println("<input type='submit' name='page' value='finish'>");
        }
        else if("finish".equals(page)) {    // �̫ᵪ�צ���
            out.println(request.getSession().getAttribute("p1q1") + "<br>");
            out.println(request.getSession().getAttribute("p1q2") + "<br>");
            out.println(request.getParameter("p2q1") + "<br>");
        }
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }
}