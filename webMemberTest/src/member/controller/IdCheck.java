package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;


@WebServlet("/idCheck.do")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String id = request.getParameter("mem_id");
		if(id.length() == 0) {
			request.setAttribute("memId", "a");
		}
		else {
			IMemberService service = MemberServiceImpl.getInstance();
			
			String memId = service.idChk(id);
			
			request.setAttribute("memId", memId);
		}
		
		
		request.getRequestDispatcher("/member/idView.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
