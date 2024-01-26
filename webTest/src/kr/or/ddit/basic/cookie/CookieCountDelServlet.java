package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCountDelServlet
 */
@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookieArr = request.getCookies();
		
				
		if(cookieArr != null) {
			//2. 쿠키 배열에서 삭제할 쿠키 정보를 구해온다
			for(Cookie cookie : cookieArr) {
				String cnt = cookie.getName();	//쿠키이름 구하기
				
				//3. 삭제할 쿠키와 이름이 같은 Cookie객체를 구한다.
				//예) 쿠키이름이 'gender'인 쿠키 삭제하기
				if("cnt".equals(cnt)) {
					//4. 삭제할 쿠키의 유지시간을 0으로 다시 설정한다
					cookie.setValue("1");;
					
					//5. 삭제할 Cookie객체를 다시 저장한다.
					response.addCookie(cookie);
				}
			}
		}
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>Cookie 삭제연습</title></head>");
		out.println("<body>");
		out.println("<h3>count가 초기화 되었습니다</h3>");
		out.println("<hr>");
		out.println("<a href='"+request.getContextPath()+"/basic/cookie/cookieTest02.jsp'>시작 문서로 이동하기</a>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
