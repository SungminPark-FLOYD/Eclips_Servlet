<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		vid = "";
		vpass = "";
		$('#chk').on('click', function (){
		    //입력한 id값을 가져온다
			id = $('#id').val().trim();
		    //서버로 전송
		    $.ajax({
		        url: "<%=request.getContextPath()%>/idCheck.do",
		        data: {'mem_id' : id},
		        type: 'get',
		        success:function (res){
		        	alert(res.flag);
		        	if(res.flag == "사용 불가능 id") {
		        		$('#id').val("");
		        		vid = "불가";
		        	}
		        	else {
		        		vid = "가능";
		        	}
		        },
		        error:function (xhr){
		            alert("상태 : " + xhr.status);
		        },
		        dataType:'json'
		    })
		})
		
		$('input#passchk').on('keyup', function (){

				pass = $('#pass').val().trim();
				
                //입력한 값을 가져온다
                passChk = $(this).val().trim();
                
                if(!(pass == passChk)){
                    //빨간색 테두리 변경
                    $(this).css('border', '5px solid red');
                    vpass = "불가";
                    
                   
                }else {
                    $(this).css('border', '5px solid blue');
                    vpass = "가능";
                    
                }
                
         })
         
         $('form').submit(function (event) {
			if(vpass == "불가") {
				alert("비밀번호를 확인 해 주세요")
				event.preventDefault();
			}
		})
         
	})
	

</script>
</head>
<body>
<h1>회원 정보 입력 폼</h1>
<form action="<%= request.getContextPath()%>/insertMember.do" method="post" enctype="multipart/form-data">
	<table border='1'>
		<tr>
			<td>회원 ID</td>
			<td><input type="text" id="id" name="id" required>
			<input type="button" id="chk" value="중복확인"></td>
		</tr>
		<tr>
			<td>비밀번호</td><td><input type="password" id="pass" name="pass" required></td>
		</tr>
		<tr>
			<td>비밀번호확인</td><td><input type="password" id="passchk" required></td>
		</tr>
		<tr>
			<td>회원 이름</td><td><input type="text" id="name" name="name" required></td>
		</tr>
		<tr>
			<td>전화번호</td><td><input type="text" id="tel" name="tel" required></td>
		</tr>
		<tr>
			<td>회원주소</td><td><input type="text" id="addr" name="addr" required></td>
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
			</td>
			
		</tr>
	
	</table>
</form>
</body>
</html>