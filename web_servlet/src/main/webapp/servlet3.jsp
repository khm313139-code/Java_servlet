<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
ArrayList<String> board = (ArrayList<String>) request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록 완료</title>
</head>
<body>
<h2>게시글 등록 완료</h2>

제목: <%=board.get(0) %><br>
작성자: <%=board.get(1) %><br>
내용: <%=board.get(2) %><br>
등록일: <%=board.get(3) %>

<input type="button" value="확인" onclick="gopage()">

</body>
<script>
function gopage(){
	location.href="./servlet3.html";
}

</script>

</html>