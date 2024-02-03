package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVo;

@WebServlet("/selectMem.do")
public class SelectMem extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memId = request.getParameter("memno");
		String page = request.getParameter("page");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		MemberVo vo = service.selectMem(memId);
		
		request.setAttribute("vo", vo);
		
		if(page.equals("de")) {			
			request.getRequestDispatcher("/member/selectView.jsp").forward(request, response);
		}
		else if(page.equals("up")) {
			request.getRequestDispatcher("/member/updateView.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
