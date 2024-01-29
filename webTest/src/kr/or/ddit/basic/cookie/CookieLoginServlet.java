package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        String userid = request.getParameter("id");
	        String password = request.getParameter("pass");
	        String remember = request.getParameter("check");
	        
	        Cookie cookie = new Cookie("id", userid);
	        
	        
	        if (remember != null && remember.equals("on")) {
	            cookie.setMaxAge(60*60*24);  
	            response.addCookie(cookie);
	        }else {
	        	cookie.setMaxAge(0);
	        	response.addCookie(cookie);
	        }
	
	       
	        if (validate(userid, password)) {
	            response.sendRedirect(request.getContextPath() + "/basic/cookie/cookieMain.jsp");
	        } else {
	            
	            response.sendRedirect(request.getContextPath() + "/basic/cookie/cookieLogin.jsp");
	        }
    }
	
    private boolean validate(String userid, String password) {
        
        return userid.equals("test") && password.equals("1234");
    }
		
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
