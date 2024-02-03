<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String res = (String) request.getAttribute("memId");
	System.out.println(res);
    if(res == null){
        %>
        {
            "flag" : "사용가능 id"
        }
<%    }else { %>
        {
            "flag" : "사용 불가능 id"
        }

<%
    }
%>