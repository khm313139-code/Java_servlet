<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String list[] = (String [])request.getAttribute("user");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함께할 조별 결과</title>
</head>
<body>
<fieldset><!--  back-end가 직접 자바 코드를 이용하여 출력한 상황 -->
	<legend>A조 - 멤버</legend>
	<% //jsp로 찍으면 크롤링 할 수 있음
	int w = 0;
	while(w<list.length){
	%>
	
	<label><%=list[w]%></label><br>

	<%
	w++;
	}
	%>
</fieldset>
<br><br>


<!-- 이건 front-end가 직접 back-end의 변수를 활용하여 js로 직접 출력하는 방식 - 크롤링 안됨 -->
<fieldset>
	<legend>A조 - 멤버</legend>
	<div id = "views">
	
	
	</div>
</fieldset>
</body>
<!-- 이건 js로 직접 찍는 것 -->
<!-- 배열을 통째로 받아버림 -->
<script>
// [권하민, 김고운] 콘솔 찍으면 이렇게 나오는데 js에서 배열은 
// var userlist = ["권하민","김고운","김동완","김예빈","박순수","신범석","허대회"] 일케 나온다.
// [권하민, 김고운] 그래서 이렇게 찍으면 json.parse가 안먹는다.
<%--
<%
	int ww = 0;
	while(ww<list.length){
	%>
		"<%=list[ww]%>"<%= "," %>
	<%
		ww++;
	}
	%>
--%>

var data = [ //js 배열임 data는 직접 만드는 거임 배열을
	//jsp로 찍으면 크롤링 할 수 있음
	<%
	int ww = 0;
	while(ww<list.length){
		out.print("'"+list[ww]+"'"+",");
		ww++;
	}
	%>
];
//console.log(data);

var node = document.getElementById("views");
var f;
for(f=0; f<data.length; f++){
	var html = document.createElement("p");
	var text = document.createTextNode(data[f]);
	html.append(text);
	node.append(html);
}


</script>






</html>