package kr.or.ddit.lprod;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lprod/lprodList2.do")
public class LprodList2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//DB에서 자료 가져오기
		ILprodService service = LprodServiceImpl.getInstance();
		List<LprodVo> lprodList = service.getList();
		
		//가져온 데이터를 Request객체에 저장한다
		request.setAttribute("lprodList", lprodList);
		
		//forward방식으로 View페이지 (JSP문서)로 이동한다
		request.getRequestDispatcher("/basic/json/lprodView.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
