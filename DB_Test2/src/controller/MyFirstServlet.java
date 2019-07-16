package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFirstServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DBController db = new DBController();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String name = request.getParameter("acc"); //取得由UI.jsp上所取得使用者輸入的姓名和密碼
		String pwd = request.getParameter("pwd");
		String Pwd_valid = db.getPwd(name);

		
	  	//登入有三種情況 1. 使用者存在，且密碼正確(導到正確登入頁面)
	  	//				 2. 使用者存在，但密碼錯誤(導到錯誤頁面，顯示密碼錯誤訊息)
	  	//				 3. 使用者不存在(導到錯誤頁面，顯示使用者不存在訊息)  	
	  	 if( Pwd_valid != null )
	   	{
	  		if(Pwd_valid.equals(pwd)) //情況 1
	  		{
	  			String message = "helloworld!" + db.getMsg(name); //產生個別使用者的歡迎訊息
	  			request.setAttribute("message",message); //request.setAttribute(指定要傳給的對象名字，傳入的參數)
	  			request.setAttribute("name",name);
	  			
	  			HttpSession session = request.getSession();
	  			session.setAttribute("name",name);
	  			
	  			request.setAttribute("cont",myLoginListener.GetSessions());
	  			
	  			Date date = new Date();
	  			System.out.println(date.toString() + " "+ name + " " + "login");
	  			request.getRequestDispatcher("IIndex.jsp").forward(request, response);
	  			return;
	  		}
	  		else //情況 2
	  		{
		  		request.setAttribute("message","密碼錯誤");
		  		request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
		  		return;	  			
	  		}
	   	}
	  	 else //情況3
	  	 {
		  	request.setAttribute("message","使用者不存在");
		  	request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
		  	return;
	  	 }
	}
}
    
