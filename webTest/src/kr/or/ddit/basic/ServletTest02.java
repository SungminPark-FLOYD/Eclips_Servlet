package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//이 예제는 어노테이션(@WebServlet)을 이용해서 Servlet을 등록하여 처리하는 예제
//어노테이션(@WebServlet)은 Servlet버전 3.0이상에서 사용할 수 있다

/*
 * @WebServlet 어노테이션의 속성들
 * 	1) name : 서블릿의 이름을 설정한다. (기본값 : 빈문자열(""))
 * 	2) urlPatterns : 서블릿의 URL패턴의 목록을 설정한다. (기본값 : 빈매열{})
 * 		예) urlPatterns = "/url1"또는 UrlPatterns={"/url1"} ==> 패턴이 1개일 경우
 * 		예) urlPatterns ={"/url1", "/url2",...} => 패턴이 2개 이상일 경우
 * 	3) value: urlPatterns와 같다.
 *  4) description : 주석(설명글)을 설정한다.
 */

@WebServlet(
	name="servletTest02", urlPatterns = {"/servletTest02.go"},
	description = "어노테이션을 이용한 서블릿 설정 연습"
)
public class ServletTest02 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "어노테이션";
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//HTML 출력하기
		//방법 2 print() 또는 println()메서드 이용하기
		out.println("<html>");
		out.print("<head><meta charset='utf-8'><title>두번째 Serlvet</title></head>");
		out.println("<body>");
		out.println("<h1 style='color:red; text-align:center;'>");
		out.println(name + " 방식으로 서블릿 설정하는 예제입니다..</h1>");
		out.println("</body></html>");
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
