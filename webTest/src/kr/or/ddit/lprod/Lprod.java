package kr.or.ddit.lprod;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/lprod.do")
public class Lprod extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		Gson gson = new Gson();
		String jsonData = null;
		
		ILprodService service = LprodServiceImpl.getInstance();
		List<LprodVo> vo = service.getList();
		System.out.println(vo);
		jsonData = gson.toJson(vo);
		
		PrintWriter out = response.getWriter();
		out.write(jsonData);
		response.flushBuffer();		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
