<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javascript 연습</title>
<script type="text/javascript">
	// 이름있는 함수와 이름없는 함수 실행하기
	console.log("이름있는 함수 실행", plus(100, 200)); // 실행되는 이유 : plus함수는 이미 그 자체에 함수를 포함하고 있어서 실행됨
	console.log("이름없는 함수 실행", minus(300, 600));	// 실행안되는 이유 : minus함수는 대입이 일어나야 함수로서 역할을 하기 떄문에 실행불가

	// 이름있는 함수 정의하기
	function plus(x, y) {
		return x + y;
	}
	 
	// 이름없는 함수 정의하기
	// 이름없는 함수를 변수에 대입하면 해당 변수의 타입은 function타입이 되고,
	// 그 변수는 함수를 참조하게 된다.
	// 그 변수명에 ()를 붙이면 그 변수가 참조하는 함수를 실행할 수 있다.
	var minus = function(x, y) {
		return x- y;
	}
	
	console.log(plus(100, 200));
	console.log(minus(300, 600));
</script>
</head>
<body>
	<h1>자바스크립트의 함수</h1>
	<p>실행결과는 브라우저 콘솔창에서 확인</p>
</body>
</html>