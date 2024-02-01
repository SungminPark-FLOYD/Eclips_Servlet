<%@page import="kr.or.ddit.basic.upload.vo.FileInfoVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
		//서블릿에서 보낸 자료 받기
		List<FileInfoVo> fileList = (List<FileInfoVo>)request.getAttribute("fileList");
	%>
</head>
<body>
	<h2>전체 파일 목록</h2><br><hr><br>
	<a href="<%=request.getContextPath()%>/fileUpload.do">파일 업로드</a><br><br>
	<table border='1'>
		<thead>
			<tr>
				<th>번호</th><th>작성자</th><th>저장파일명</th><th>원래의 파일명</th><th>파일 크기</th>
				<th>날짜</th><th>비고</th>
			</tr>
		</thead>
		<tbody>
			<% 
				if(fileList == null || fileList.size() == 0) {
			%>
				<tr><td colspan="7" style="text-align : center">Upload한 파일 목록이 하나도 없습니다.</td></tr>
			<% 
				}else {
					for(FileInfoVo fileVo : fileList) {
			%>
					<tr>
						<td><%=fileVo.getFile_no() %></td>
						<td><%=fileVo.getFile_writer() %></td>
						<td><%=fileVo.getSave_file_name() %></td>
						<td><%=fileVo.getOrigin_file_name() %></td>
						<td><%=fileVo.getFile_size() %></td>
						<td><%=fileVo.getFile_date() %></td>
						<td>DownLoad</td>
					</tr>
			
			<%
					}
				}
				
			%>
		</tbody>
	</table>
</body>
</html>