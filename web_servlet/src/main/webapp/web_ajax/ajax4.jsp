<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>


<%
	//trimDirectiveWhitespaces="true" : false(자바코드를 입력된 사항을 공백처리), true(자바코드 공백 모두 삭제)
	//위 코드는 ajax 통신할 경우에만 사용한다 절대 html 코드를 쓰면 안된다 쓰면 html 코드도 날라간다
	//주석 써도 날라가서 여기에 쓰는거임
	String msg = (String)request.getAttribute("msg");
%>

<%=msg %>
