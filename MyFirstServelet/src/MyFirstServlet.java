import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyFirstServlet")

public class MyFirstServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;	
	private Hello hello = new Hello();
   
	//servlet 取得由Container所建立的的request&response
	//至於Container如何去和 servlet 去做對應
	//這裡就要整理一下web.xml
	//也就是部屬描述檔(Deployment Descriptor,簡稱DD)
	//Container藉由這個DD來得知如何去執行 servlet 及JSP
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		request.getRequestDispatcher("login.jsp").forward(request, response);
		//forward由request.getRequestDispatcher去做呼叫
		//這裡有再加上一個return;代表跳轉過去就不再執行下面的code了
		//使用forward由於內部呼叫,在client上並不會看到程式的名稱
		//而是在JSP中設定action的名稱
		
} 
    public void setMsg(String user){
    	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String name = request.getParameter("name"); //取得由login.jsp上所取得使用者輸入的姓名和密碼
		String pwd = request.getParameter("mypassword");
		
	  	String secretPassword = hello.getPassword(name); //取得使用者的密碼
		
	  	//登入有三種情況 1. 使用者存在，且密碼正確(導到正確登入頁面)
	  	//				 2. 使用者存在，但密碼錯誤(導到錯誤頁面，顯示密碼錯誤訊息)
	  	//				 3. 使用者不存在(導到錯誤頁面，顯示使用者不存在訊息)
	  	
	  	 if(hello.userIsExist(name))
	   	{
	  		if(secretPassword.equals(pwd)) //情況 1
	  		{
	  			String message = hello.doHello(name); //產生個別使用者的歡迎訊息
	  			request.setAttribute("message",message); //request.setAttribute(指定要傳給的對象名字，傳入的參數)
	  			request.setAttribute("name",name);
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
