package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest01 extends HttpServlet{
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "홍길동";

        response.setCharacterEncoding("utf-8"); //응답 문서의 인코딩 방식 지정
        response.setContentType("text/html;charset=utf-8"); //응답 문서의 ContentType 설정

        //처리한 내용을 응답으로 보내기 위한 스트림 객체 생성 => PrintWriter객체 생성
        PrintWriter out = response.getWriter();
        //처리한 내용을 출력한다 (hmtl형식의 내용을 작성하여 출력한다)
        //방법1) append()메서드 이용하기
        out.append("<html>")
                .append("<head>")
                .append("<meta charset='utf-8'>")
                .append("<title>첫번째 Servlet 연습</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1 style='text-align:center;'>")
                .append(name + "씨 안녕하세요. 첫번째 Servlet 프로그램입니다.</h1>")
                .append("</body></html>");

    }

    //doPost()메서드 ==> Post방식의 요청을 처리하는 메서드
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
