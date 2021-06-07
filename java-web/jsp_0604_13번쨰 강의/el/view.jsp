<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div class="row">
		<div class="col-12">
			<h1>제목 : ${title}</h1>
		</div>
		<div class="col-12">
			<dl>
				<dt>성</dt><dd>${socre.lastName}</dd>
				<dt>이름</dt><dd>${score.firstName}</dd>
				<dt>전체이름</dt><dd>${socre.lasttName} ${score.firstName}</dd>
				<dt>국어점수</dt><dd>${score.kor}</dd>
				<dt>영어점수</dt><dd>${score.eng}</dd>
				<dt>수학점수</dt><dd>${score.math}</dd>
				<dt>총점</dt><dd>${score.kor + score.eng + score.math}</dd>
				<dt>평균</dt><dd>${(score.kor + score.eng + score.math)/3}</dd>
			</dl>
		</div>
		<div class="col-12">
			<div>부서번호 : ${deptInfo.deptNo }</div>
			<div>부서이름 : ${deptInfo.deptName }</div>
			<div>부서주소 : ${deptInfo.deptAddr }</div>
			<div>부서관리자명 : ${deptInfo.deptManagerName }</div>			
		</div>
		
		<div class="col-12">
			<div>비어있는가? ${empty username } 비어있지 않은가? ${not empty username }</div>
			<div>비어있는가? ${empty userpassword } 비어있지 않은가? ${not empty userpassword }</div>
			<div>비어있는가? ${empty members } 비어있지 않은가? ${not empty members }</div>
			<div>비어있는가? ${empty teams } 비어있지 않은가? ${not empty teams }</div>
			<div>비어있는가? ${empty colors } 비어있지 않은가? ${not empty colors }</div>
		</div>
		
		<div class="col-12">
			<table class="table">
				<thead>
					<tr>
						<th>이름</th>
						<th>국어</th>
						<th>영어</th>
						<th>수학</th>
						<th>총점</th>
						<th>평균</th>
						<th>장학금 지급 여부</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${scoreList[0].fullName}</td>
						<td>${scoreList[0].kor }</td>
						<td>${scoreList[0].eng }</td>
						<td>${scoreList[0].math }</td>
						<td>${scoreList[0].total}</tD>
						<td>${scoreList[0].average}</tD>
						<td>${scoreList[0].average >= 90}</td>
					</tr>
					<tr>
						<td>${scoreList[1].fullName}</td>
						<td>${scoreList[1].kor }</td>
						<td>${scoreList[1].eng }</td>
						<td>${scoreList[1].math }</td>
						<td>${scoreList[1].total}</td>
						<td>${scoreList[1].average}</td>
						<td>${scoreList[1].average ge 90 ? "지급" : "지급안함"}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>