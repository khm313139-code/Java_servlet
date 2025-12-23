<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<ArrayList<String>> result = (ArrayList<ArrayList<String>>)request.getAttribute("result");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 검색 결과</title>

</head>
<body>

<h2>도서 검색 결과</h2>

<%
if(result == null || result.size() == 0){
%>
    <p>검색 결과가 없습니다.</p>
<%
}else{
%>

<table>
    <tr>
        <th>책 이름</th>
        <th>저자</th>
        <th>가격</th>
    </tr>

<%
    for(int i = 0; i < result.size(); i++){
        ArrayList<String> book = result.get(i);
%>
    <tr>
        <td><%=book.get(0)%></td>
        <td><%=book.get(1)%></td>
        <td><%=book.get(2)%> 원</td>
    </tr>
<%
    }
%>

</table>

<%
}
%>

</body>
</html>
