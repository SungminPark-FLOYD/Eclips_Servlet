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
<h1>회원 정보 수정하기</h1>
<form action="<%= request.getContextPath()%>/memberUpdate.do" method="post" enctype="multipart/form-data">
	<table border='1'>
		<tr>
			<td colspan="2"><img src="<%= request.getContextPath() %>/imageView.do?memno=<%=vo.getMem_id() %>"></td>
		</tr>
		<tr>
			<td>회원ID</td>			
			<td><input type="hidden" name="memid" value="<%=vo.getMem_id()%>"><%=vo.getMem_id() %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pass" required="required"></td>
		</tr>
		<tr>
			<td>회원이름</td>
			<td><input type="text" name="name" value="<%=vo.getMem_name() %>" required="required"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="tel" value="<%=vo.getMem_tel() %>" required="required"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="addr" value="<%=vo.getMem_addr() %>" required="required"></td>
		</tr>
		<tr>
			<td>프로필 사진</td>
			<td><input type="file" name="file" required></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center">
			<input type="submit" id="sub" value="저장">
			<input type="reset" value="취소">
			<input type="button" value="회원목록" onclick="location.href='<%=request.getContextPath()%>/memberList.do'">
		</tr>
	</table>
</form>
</body>
</html>