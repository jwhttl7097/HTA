<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청파라미터값 조회하기</title>
</head>
<body>
	<h1>요청파라미터값 조회</h1>

	<h3>요청 파라미터값 조회하기</h3>
	<%
		// category라는 이름으로 서버로 전송된 요청 파라미터 값 조회하기
		String category = request.getParameter("category");
		// no라는 이름으로 서버로 전송된 요청파라미터 값 조회하기
		String no = request.getParameter("no");
	%>
		<dl>
			<dt>카테고리</dt><dd><%=category %></dd>
			<dt>번호</dt><dd><%=no %></dd>
		</dl>
</body>
</html>