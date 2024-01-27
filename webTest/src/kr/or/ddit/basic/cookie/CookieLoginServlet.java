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
	
	        // If the user checked 'Remember me', save their ID in a cookie
	        String remember = request.getParameter("check");
	        if (remember != null && remember.equals("on")) {
	            Cookie cookie = new Cookie("id", userid);
	            cookie.setMaxAge(60*60*24);  // expire in 1 day
	            response.addCookie(cookie);
	        }
	
	        // Validate the user's credentials
	        if (validate(userid, password)) {
	            // Redirect to the main page
	            response.sendRedirect(request.getContextPath() + "/basic/cookie/cookieMain.jsp");
	        } else {
	            // Redirect back to the login page
	            response.sendRedirect(request.getContextPath() + "/basic/cookie/cookieLogin.jsp");
	        }
	    }
	
	    private boolean validate(String userid, String password) {
	        // Validate the user's credentials. This is just a placeholder.
	        return userid.equals("test") && password.equals("1234");
	    }
		
		
		
		
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
