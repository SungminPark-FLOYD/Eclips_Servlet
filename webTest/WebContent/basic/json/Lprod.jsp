<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
		$("#lprod").on("click", function(){
			$.ajax({
				url : "<%=request.getContextPath()%>/lprod.do",
				type : 'post',
				success : function (resData) {	//resData => 응답데이터가 저장될 변수
					let htmlCode = "<table border='1'>";
					
					htmlCode += "<tr><td>LPROD_ID</td><td>LPROD_GU</td><td>LPROD_NM</td></tr>";
					
					$.each(resData, function(i,v) {
						htmlCode += `<tr><td>\${v.lprod_id}</td><td>\${v.lprod_gu}</td><td>\${v.lprod_nm}</td></tr>`;
					});
					
										
					htmlCode += "</table>";
					$('#result').html(htmlCode);
				},
				error : function(xhr){
					alert("상태 : " + xhr.status);
				},
				dataType : 'json'
			})
		}); //- 문자열 처리
		
		$("#lprod2").on("click", function(){
			location.href = "<%=request.getContextPath()%>/lprod/lprodList2.do";
		}); //- 문자열 처리
	})
</script>
</head>
<body>
<form>
<input type="button" value="Lprod자료 가져오기(Ajax)" id="lprod">
<input type="button" value="Lprod자료 가져오기(동기방식)" id="lprod2">
<h1>Lprod 자료 목록</h1>
</form>
<div id="result">
</div>
</body>
</html>