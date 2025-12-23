<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% //하나의 뷰에 두개의 컨트롤이 묶여있는 상황
    String message = (String) request.getAttribute("message"); 
    String part = (String)request.getAttribute("part");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 확인 페이지</title>
<!--  사용자 정보 출력하기 위해 jsp 만들었다. -->
</head>
<body>

<!-- 1:1 하나의 컨트롤에 하나의 뷰가 붙는 경우 -->
<!-- 1:n 여러개의 컨트롤에 하나의 뷰가 붙는 경우 -->
<% 
//form이 각각 돈다는건 coupang 로그인 페이지 보면됨 url 안바뀜 -> 이메일, 휴대폰, qr로그인 선택시
//창에서 뭔가 선택했을 경우 url이 안바뀌는 건 form을 여러개 사용하고 있다는 것이다.
//페이지가 바뀌는 것은 다른 페이지라 form하고 관련 없음

if(part.equals("id")){
%>
아이디: <%=message%>
<% 
}else{
%>

	패스워드: <%=message%>
<% 
}
%>







</body>
</html>