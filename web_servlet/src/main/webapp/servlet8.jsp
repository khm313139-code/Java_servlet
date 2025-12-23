<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% //servlet8.jsp는 servlet8.html 없음 그냥 do에 바로 띄움
    	Integer number_people = (Integer)request.getAttribute("person");
    	ArrayList<String> user = (ArrayList)request.getAttribute("userdata");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>[회원가입자 총 인원 수 : <%=number_people%>명]</p>
<ol>
<%
int w = 0;
while(w<user.size()){
	
%>
<li><%=user.get(w)%></li>
<%
	w++;
}
%>

</ol>
</body>
</html>