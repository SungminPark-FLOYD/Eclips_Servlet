<%@page import="com.sun.xml.internal.bind.v2.runtime.Location"%>
<%@page import="member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	MemberVo vo = (MemberVo)request.getAttribute("vo");
%>

<style type="text/css">
img{
	width:300px;
	height: 250px;
}
</style>
</head>
<body>
<h1>회원 정보 상세보기</h1>

<table border='1'>
	<tr>
		<td colspan="2"><img src="<%= request.getContextPath() %>/imageView.do?memno=<%=vo.getMem_id() %>"></td>
	</tr>
	<tr>
		<td>회원ID</td>
		<td><%=vo.getMem_id() %></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><%=vo.getMem_pass() %></td>
	</tr>
	<tr>
		<td>회원이름</td>
		<td><%=vo.getMem_name() %></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><%=vo.getMem_tel() %></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><%=vo.getMem_addr() %></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="button" id="update" value="수정" onclick="location.href='<%=request.getContextPath()%>/selectMem.do?page=up&&memno=<%=vo.getMem_id()%>'">
		<input type="button" id="delete" value="삭제" onclick="location.href='<%=request.getContextPath()%>/memberDelete.do?memid=<%=vo.getMem_id()%>'">
		<input type="button" value="회원목록" onclick="location.href='<%=request.getContextPath()%>/memberList.do'">
	</tr>
</table>
</body>
</html>