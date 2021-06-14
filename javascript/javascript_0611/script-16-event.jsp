<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트 이벤트</title>
</head>
<body>
	<h1>키보드 이벤트</h1>
	
	<div>
		<!-- 
			속성			사용대상 			주 사용목적
			---------------------------------------------------------
			id			모든 엘리먼트		스타일적용 및 자바스크립트 엘리먼트 검색
			class		모든 엘리먼트		스타일적용
			name		form입력요소		폼입력값을 서버로 전송할 때 값의 이름
			---------------------------------------------------------
		 -->
		<input type="text" id="user-id" name="userid"
			onkeydown="handler1(event)" onkeypress="handler2()" onkeyup="handler3()">
	</div>
	<script type="text/javascript">
		function handler1(e) {
			var el = document.getElementById("user-id");
			var inputValue = el.value;
			console.log("onkeydown 이벤트 실행", inputValue);
			console.log(e.key, e.which);
		}
		function handler2() {
			var el = document.getElementById("user-id");
			var inputValue = el.value;
			console.log("onkeypress 이벤트 실행", inputValue);
		}
		function handler3() {
			var el = document.getElementById("user-id");
			var inputValue = el.value;
			console.log("onkeyup 이벤트 실행", inputValue);
		}
	</script>
</body>
</html>