package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		Cookie cntCookie = new Cookie("cnt", "1");

		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>Cookie Count</title></head>");
		out.println("<body>");
		Cookie[] cookieArr = request.getCookies();
		if(cookieArr != null) {
			for(Cookie cookie : cookieArr) {
				String name = cookie.getName();
				
				if("cnt".equals(name)) {
					String value = cookie.getValue();					
					out.println("<h3>어서오세요. 당신은 " + value + " 번째 방문입니다.</h3><br><br>");
					int cnt = Integer.parseInt(value)+1;
					cookie.setValue(cnt + "");
					response.addCookie(cookie);
				}
			}
		}
		
		out.println("<a href='"+request.getContextPath()+"/cookieCountServlet.do'>카운트 증가하기</a>");
		out.println("<a href='"+request.getContextPath()+"/basic/cookie/cookieTest02.jsp'>시작 문서로 이동하기</a>");
		out.println("</body></html>");			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
