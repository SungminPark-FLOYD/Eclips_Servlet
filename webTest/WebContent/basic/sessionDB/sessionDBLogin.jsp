<%@page import="kr.or.ddir.sessionlogin.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <%
 	MemberVo vo = (MemberVo)session.getAttribute("LoginMember");

 	/* String dis1 = "";
 	String dis2 = "none";
 	
 	if(vo != null) {
 		 dis1 = "none";
 	 	 dis2 = null;
 	} */
 	
 	//그냥 if문으로 table과 div를 나눠서 감싸도 된다.
 %>

</head>
<body>

<form action="<%=request.getContextPath()%>/sessionDBLogin.do" method="post">
 <% if(vo == null) { %>
<table border="1">
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
<% } else {%>
<div>
	<h1><%= vo.getMem_id()%>님 반갑습니다.</h1>
	<br><br><br>
	<a href="<%=request.getContextPath()%>/sessionDBLogout.do">로그아웃</a>
</div>
<%} %>
</form>
</body>
</html>