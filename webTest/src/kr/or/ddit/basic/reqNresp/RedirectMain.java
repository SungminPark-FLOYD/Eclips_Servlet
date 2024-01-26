package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/redirectMain.do")
public class RedirectMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 	- redirect 방식
		 * 	  다른 페이즈로 이동하는 것을 말한다. (Request객체와 Response객체가 공유되지 않는다)
		 * 	 응답시 브라우저에게 '이동할 URL'을 전송하여 브라우저가 해당 URL로 이동하는 방식이다.
		 * 	이동할 때는 GET방식으로 요청하기 때문에 URL의 길이에 저한이 있다
		 *  
		 */
		//redirect는 처음 요청할 때 만들어진 Request객체와 Response객체를 
		// 이동하는 문서에서 유지하지 못한다. (이유: 브라우저에서 새롭게 요청하기 때문에..)
		
		// 처음 요청할 때 먼저 파라미터를 받는다
		String username = request.getParameter("username");
		
//		request.setAttribute("tel", "010-8888-8888");
//		response.sendRedirect(request.getContextPath()+"/redirectTarget.do");
		
		//redirect방식으로 이동하기
		// => Response객체의 sendRedirect()메서드를 이용한다.
		// 형식) Response.sendRedirect("이동할 문서의 전체 URL주소");
		// => 이동할 주소에 한글이 있을 경우에는 URLEncoder를 이용하여 인코딩해서 
		//    지정해 주어야 한다.
		//getContextPath로 프로젝트가 바뀌어도 적용될 수 있게 만든다
		response.sendRedirect(request.getContextPath()
				+"/redirectTarget.do?username="+ username + "&tel=010-8888-8888");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
