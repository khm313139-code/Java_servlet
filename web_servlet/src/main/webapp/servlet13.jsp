<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String message = (String)request.getAttribute("message");
    ArrayList<String> userinfo = (ArrayList<String>)request.getAttribute("userinfo");
%>


<script>
    <%=message%>
</script>




<% 
if(userinfo.size()>0) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>
</head>
<body>
가입자 정보: <%=userinfo.get(0)%>
</body>
</html>


<% 
} 
%>

