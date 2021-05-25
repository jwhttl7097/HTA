<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청헤더정보 조회하기</title>
</head>
<body>
   <h1>요청헤더 정보 조회하기</h1>
   <%
      //요청메시지의 요청헤더 정보를 조회하기
      String agent = request.getHeader("user-agent");
      String language = request.getHeader("accept-language");
      String contentType = request.getHeader("accept");
      String encoding = request.getHeader("accept-encoding");
   %>
   <dl>
      <dt>클라이언트의 브라우저 정보</dt><dd><%=agent %></dd>
      <dt>클라이언트가 선호하는 언어</dt><dd><%=language %></dd>
      <dt>클라이언트가 선호하는 컨텐츠타입</dt><dd><%=contentType %></dd>
      <dt>클라이언트가 선호하는 압축방식</dt><dd><%=encoding %></dd>
   </dl>
   
   <p><a href="main.jsp">메인페이지로 돌아가기</a></p>
</body>
</html>