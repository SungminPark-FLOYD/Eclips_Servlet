package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest02
 */
@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String fnum = request.getParameter("fnum");
		String r = request.getParameter("r");
		String snum = request.getParameter("snum");
		
		int fn = Integer.parseInt(fnum);
		int sn = Integer.parseInt(snum);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>Request객체 연습</title></head>");
		out.println("<body>");
		out.println("<h2>계산 결과</h2>");
		out.println("<hr>");
		out.println(fnum + " " + r + " " + snum + " = ");
		
		boolean calcOk = true; // 계산이 성공하면  true값으로 세팅
		double result = 0;
		switch(r) {
			case "+" : result = fn + sn; break;
			case "-" : result = fn - sn; break;
			case "*" : result = fn * sn; break;
			case "/" : if(sn != 0) result = fn / sn; 
						else calcOk = false; break;
			case "%" : if(sn != 0) result = fn % sn; 
						else calcOk = false; break;
		}
		if(calcOk == true) {
			out.println(result);
		}
		else {
			out.println("계산 불능!");
		}
		
		
//		if(r.equals("+")) {
//			out.println(fn+sn);
//		}
//		else if(r.equals("-")) {
//			out.println(fn-sn);
//		}
//		else if(r.equals("*")) {
//			out.println((double)fn*sn);
//		}
//		else if(r.equals("/")) {
//			out.println((double)fn/sn);
//		}
//		else if(r.equals("%")) {
//			out.println((double)fn%sn);
//		}
		out.println("</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
