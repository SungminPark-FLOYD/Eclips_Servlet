package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddir.sessionlogin.vo.MemberVo;


@WebServlet("/jsonTest.do")
public class JsonTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ajax를 이용한 요청을 처리하고 응답을 JSON객체로 반환하는 Servlet예제
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
	
		//파라미터 구하기
		String choice = request.getParameter("choice");
		
		Gson gson = new Gson();
		String jsonData = null;	//처리된 데이터가 JSON문자열로 저장될 변수
		
		switch(choice) {
			case "string" : 
				String str = "안녕하세요";
				
				//처리된 데이터를 JSON문자열로 변환하기
				jsonData = gson.toJson(str);
				break;
			case "array" :
				int[] arr = {10, 20, 30, 40, 50};
				jsonData = gson.toJson(arr);
				break;
			case "object" :
				MemberVo memVo = new MemberVo("z001", "1111", "홍길동", "010-1111-1111", "대전");
				jsonData = gson.toJson(memVo);
				break;
			case "list" :
				List<MemberVo> memList = new ArrayList<MemberVo>();
				memList.add(new MemberVo("a", "10", "홍", "02", "서울"));
				memList.add(new MemberVo("b", "20", "김", "042", "대전"));
				memList.add(new MemberVo("c", "30", "이", "041", "충남"));
				memList.add(new MemberVo("d", "40", "박", "043", "충북"));
				jsonData = gson.toJson(memList);
				break;
			case "map" :
				Map<String, String> map = new HashMap<String, String>();
				map.put("name", "이순신");
				map.put("tel", "010-1234-1234");
				map.put("addr", "대전 중구");
				jsonData = gson.toJson(map);
				break;
		}
		
		System.out.println(choice + "==> " + jsonData);
		
		PrintWriter out = response.getWriter();
		out.write(jsonData);
		response.flushBuffer();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
