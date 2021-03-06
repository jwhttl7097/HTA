<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
     <title>Bootstrap 4 Example</title>
     <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
     <style type="text/css">
     	div{
     		border: 1px solid black;
     		padding: 16px;
     		margin: 15px;
     	}
     	.prev{
     		color: gray;
     	}
     </style>
</head>
<body>
<div class="container">
    <h1>이벤트 처리</h1>
   
   	<div>
   		<input type="number" value="1" class="w-50"><button id="btn-1" class="btn btn-outline-primary">버튼1</button>
   		<input type="number" value="1" class="w-50"><button id="btn-2" class="btn btn-outline-primary">버튼2</button>
   		<input type="number" value="1" class="w-50"><button id="btn-3" class="btn btn-outline-primary">버튼3</button>
   		<input type="number" value="1" class="w-50"><button id="btn-4" class="btn btn-outline-primary">버튼4</button>
   	</div>
</div>
<script type="text/javascript">
	$('button').on('click', function(){
		// - jQuery 이벤트핸들러함수 this에는 언제나 이벤트를 발생시킨 그 엘리먼트가 들어있다.
		// - this에는 엘리먼트 객체가 들어있다. jQuery객체가 아니다.
		// - this에 대하여 $(this)를 실행하면 
		//   this에 들어있는 엘리먼트와 그 엘리먼트를 조작하는 조작함수가 포함된 jQuery객체가 반환된다.
		// * this.jQuery조작함수 		<-- 오류
		// * $(this).jQuery조작함수() <-- 정상동작
		console.log(this);
		$(this).css('color', 'red')
		
		$(this).prop('disabled', true).prev().val(10000);
// 		$(this).prev().val(10000).prop('disabled', true);
	})		
	var x = $('button'); // x에는 jQuery객체가 들어있다.
// 	x.css('color', 'red');
</script>
</body>
</html>