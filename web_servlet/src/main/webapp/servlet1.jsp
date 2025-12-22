<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 String message = (String) request.getAttribute("message"); //jsp에서 만든 변수명임 근데 일단 똑같은거로 사용
 //byte로 넘어와서 string으로 변환
 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색한 사용자 레벨 정보</title>
</head>
<body>
결과값 출력: <% out.print(message); %>
</body>
</html>