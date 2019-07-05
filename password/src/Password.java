import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.Random;
import java.util.stream.Collectors;

import javax.imageio.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/password")
public class Password extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("image/jpeg");

        String passwd = new Random().ints(0, 10)
                                    .limit(4)
                                    .mapToObj(String::valueOf)
                                    .collect(Collectors.joining());

        // ��ڳ��X�����N���ͪ����ҽX�s�b�Y�Ӧa��A�H�Ѥ�����

        ImageIO.write(
            passwordImage(passwd), 
            "JPG", 
            response.getOutputStream() //getWriter() �P getOutputStream() �u��ܤ@�ϥ�
        );
    }

    // �@�� Java 2D ���F��A�@�ά��̶ǤJ���Ʀr���͹Ϥ�
    private BufferedImage passwordImage(String password) throws IOException {
        BufferedImage bufferedImage =
                 new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
        g.setColor(Color.WHITE);
        g.setFont(new Font("�з���", Font.BOLD, 16));
        g.drawString(password, 10, 15);
        return bufferedImage;
    }
}