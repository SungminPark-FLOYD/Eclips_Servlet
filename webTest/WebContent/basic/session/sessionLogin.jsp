<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <%
 	String id = (String)session.getAttribute("id");

 	String dis1 = "";
 	String dis2 = "none";
 	
 	if(id != null) {
 		 dis1 = "none";
 	 	 dis2 = null;
 	}
 	
 	

 %>
</head>
<body>
<form action="<%=request.getContextPath()%>/sessionLogin.do" method="get">
<table border="1" style="display:<%= dis1%>">
	<tr>
		<td>ID : </td>
		<td><input type="text" id="id" name="id" placeholder="ID를 입력하세요"></td>
	</tr>
	<tr>
		<td>PASS : </td>
		<td><input type="password" id="pass" name="pass" placeholder="PASSWORD를 입력하세요"></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: center;"><input type="submit" value="Login"></td>
	</tr>
</table>

<div style="display:<%= dis2%>">
	<h1><%= id%>님 반갑습니다.</h1>
	<br><br><br>
	<a href="<%=request.getContextPath()%>/sessionLogout.do">로그아웃</a>
</div>
</form>
</body>
</html>