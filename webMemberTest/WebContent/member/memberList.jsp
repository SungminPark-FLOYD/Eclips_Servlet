<%@page import="member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	List<MemberVo> memList = (List<MemberVo>)request.getAttribute("memList");
%>

<script type="text/javascript">
window.onload = function () {
    document.getElementById("insert").addEventListener("click", function () {
      location.href = "http://localhost/webMemberTest/member/insertMember.jsp";
    })
  }
</script>
</head>
<body>
<h1>회원 목록 보기</h1><br><br>
<table border='1'>
	<thead>
		<tr>
			<td colspan="5">
				<input type="button" id="insert" value="회원추가" style="float : right">
			</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>ID</th>
			<th>비밀번호</th>
			<th>이 름</th>
			<th>전 화</th>
			<th>주 소</th>
		</tr>	
		<% 
				if(memList == null || memList.size() == 0) {
			%>
				<tr><td colspan="5" style="text-align : center">회원 목록이 하나도 없습니다.</td></tr>
			<% 
				}else {
					for(MemberVo memVo : memList) {
			%>
					<tr>
						<td><a href="<%=request.getContextPath()%>/selectMem.do?page=de&&memno=<%=memVo.getMem_id()%>"><%=memVo.getMem_id() %></a></td>
						<td><%=memVo.getMem_pass() %></td>
						<td><%=memVo.getMem_name() %></td>
						<td><%=memVo.getMem_tel() %></td>
						<td><%=memVo.getMem_addr() %></td>						
					</tr>
			
			<%
					}
				}
				
			%>
	</tbody>



</table>
</body>
</html>