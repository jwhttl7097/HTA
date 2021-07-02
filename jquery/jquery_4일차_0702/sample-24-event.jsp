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
</head>
<body>
<div class="container">
    <h1>hover(onmouseenter와 onmouseleave) 이벤트 처리</h1>
    
    <div class="row">
    	<div class="col-7">
    		<div class="row" id="img-items">
    			<div class="col">
    				<div>
    					<img src="images/1.jpg" alt="사진1" class="img-thumbnail"/>
    				</div>
    			</div>
    			<div class="col">
    				<div>
    					<img src="images/2.jpg" alt="사진2" class="img-thumbnail"/>
    				</div>
    			</div>
    			<div class="col">
    				<div>
    					<img src="images/3.jpg" alt="사진3" class="img-thumbnail"/>
    				</div>
    			</div>
    		</div>
    	</div>
    	<div class="col-5">
    		<div class="border p-5 bg-light">
    			<img src="images/2.jpg" alt="사진2" class="img-thumbnail" id="img-box"/>
    		</div>
    	</div>
    </div>
</div>
<script type="text/javascript">
	$(function() {
		$("#img-box").css('opacity', '0.4');
		
		$("#img-items img").hover(function() {
			var imagePath = $(this).attr("src");
			$("#img-box").attr("src", imagePath).css("opacity", '1.0');
		}, function() {
			$("#img-box").css('opacity', '0.4');
		});
	})
</script>
</body>
</html>