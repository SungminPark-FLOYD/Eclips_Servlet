<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(() => {
    var name, id;
    
    // JavaScript에서 쿠키를 읽어오는 함수
    function getCookie(name) {
        var value = "; " + document.cookie;
        var parts = value.split("; " + name + "=");
        if (parts.length === 2) return parts.pop().split(";").shift();
    }

    name = getCookie("id");
    if (name !== undefined) {
        id = name;
        $('#id').val(id);
    }
});
</script>
<%
	//쿠키값 userId가 저장될 변수 선언
	String cookieUserId = "";
	
	//checkbox체크 여부 나타낼 변수 선언
	String chk = "";
	
	
	//쿠키 정보 가져오기
	Cookie[] cookieArr = request.getCookies();
	if(cookieArr != null) {
		for(Cookie cookie : cookieArr) {
			//쿠키이름이 "id"인 쿠키의 쿠키값 구하기
			if("id".equals(cookie.getName())){
				cookieUserId = cookie.getValue();
				chk = "checked";
				break;
			}
		}
	}
%>
<style>
div {
	border: 2px solid black;
}
</style>
</head>
<body>
<form action="<%=request.getContextPath()%>/cookieLoginServlet.do" method="post">
<div >
	<lable>ID : </lable>
	<input type="text" id="id" name="id" placeholder="ID를 입력하세요."><br>
	<lable>PASS : </lable>
	<input type="text" id="pass" name="pass" placeholder="PassWord를 입력하세요."><br>
	
	<input type="checkbox" id="check" name="check" <%=chk %>>id 기억하기<br><br>
	<input type="submit" value="Login">
</div>
</form>
</body>
</html>