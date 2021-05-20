<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청파라미터값 조회하기</title>
</head>
<body>
	<h1>GET 방식으로 전달받은 요청파라미터값(폼 입력값) 조회하기</h1>

	<h3>요청 파라미터값 조회하기</h3>
	<%
		// 요청파라미터값 조회
		String opt = request.getParameter("opt");
		String keyword = request.getParameter("keyword");
		String order = request.getParameter("order");
		String rows = request.getParameter("rows");
		
	%>
		<dl>
			<dt>검색옵션</dt><dd><%=opt %></dd>
			<dt>검색어</dt><dd><%=keyword %></dd>
			<dt>정렬순서</dt><dd><%=order %></dd>
			<dt>목록갯수</dt><dd><%=rows %></dd>
		</dl>
</body>
</html>