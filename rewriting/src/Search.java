import java.io.*;
import java.util.Optional;
import java.util.stream.IntStream;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/search")
public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("</head>");
        out.println("<body>");

        out.println("<ul>");
        IntStream.rangeClosed(1, 10)
                 .forEach(i -> out.printf("<li>�j�M���G %d</li>%n", i));
        out.println("</ul>");

        String page = Optional.ofNullable(request.getParameter("page"))
                              .orElse("1");

        int p = Integer.parseInt(page);
        IntStream.rangeClosed(1, 10)
                 .forEach(i -> {
                     if(i == p) {
                         out.println(i);
                     }
                     else {
                         out.printf("<a href='search?page=%d'>%d</a>%n", i, i);
                     }
                 });

        out.println("</body>");
        out.println("</html>");
    }
} 