<%@page import="com.sample.hr.vo.Location"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.hr.dao.LocationDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리 :: 부서관리</title>
</head>
<body>
	<h1>새 부서 등록 페이지</h1>
	<p>부서이름과 부서 소재지를 입력하고, 새 부서를 등록하세요</p>
	
	<%
		LocationDao locationDao = new LocationDao();
		List<Location> locations = locationDao.getAllLocations();
	%>
	
	<h3>새 부서정보 등록폼</h3>
	<form action="add.jsp" method="post">
		<label>부서명</label>
		<input type="text" name="name"> <br>
		<label>부서 소재지</label> <br>
		<select name="locationId">
		<%
			for (Location loc : locations) {
		%>
			<option value="<%=loc.getId() %>"><%=loc.getCity() %>(<%=loc.getCountryId() %>)</option>
		<%
			}
		%>
		</select> <br>
		<button type="submit">부서 등록</button>
	</form>
</body>
</html>