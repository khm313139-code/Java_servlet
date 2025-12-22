<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	String user = "에이핑크";
	Integer number = 123456789; //javascript에 할당
	String userid = "apink"; //html value에 할당
	String color1 = "blue"; //css에 값을 할당
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>

<!-- 
include file 다른 외부에 .jsp 파일을 가져올 때 사용합니다. (변수, 상수 같은 사항을 상속받음) 
include page 동적 웹페이지이므로, main.jsp에 상속 받지 못함. 그래서 include page는 추천하지 않는다.
-->

<!--  include file 이나 include page 는 .jsp로 시작하는 파일만 로드 합니다 .html 파일을 로드 해봤자 한글 다 깨져서 나온다. -->


<!--  include page는 동적 웹페이지 출력할 때 사용 -->
<%--
<jsp:include page = "./top.jsp" ></jsp:include>
--%>

<%@ include file = "./top.jsp" %>


</header>


<main>
<section>공지사항 및 상품 출력</section>
<br>
<input type = "button" value = "클릭" onclick="abc()"><br>
<input type = "text" value = "<%=userid%>" class="box">
</main>
<footer>
<%@ include file = "./bottom.jsp" %>
</footer>
</body>

<style>
.box{
background-color: <%=color1%>;
}
</style>


<script>
function abc(){
	var n = <%=number%>;
	alert(n);

}
</script>
</html>