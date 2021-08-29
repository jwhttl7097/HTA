<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" >
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>샘플 애플리케이션</title>
</head>
<body>
<div class="container my-3">
	<header>
		<c:set var="menu" value="home"/>
		<%@ include file="common/nav.jsp" %>
	</header>
	<main>
		<div class="row my-3">
			<div class="col">
				<div class="bordered bg-light fw-bold p-2">첨부파일 상세정보</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
				<table class="table">
					<colgroup>
						<col width="15%">
						<col width="35%">
						<col width="15%">
						<col width="35%">
					</colgroup>
					<tbody>
						<tr>
							<th>제목</th>
							<td>${file.title }</td>
							<th>작성자</th>
							<td>${file.writer }</td>
						</tr>
						<tr>
							<th>첨부파일 갯수</th>
							<td>${file.amount } 개</td>
							<th>등록일</th>
							<td><fmt:formatDate value="${file.createdDate }" pattern="yyyy년 M월 d일"/></td>
						</tr>
						<tr>
							<th>설명</th>
							<td colspan="3">${file.description }</td>
						</tr>
					</tbody>
				</table>
				<div class="mt-3 text-end">
					<a href="delete?no=${file.no }" class="btn btn-outline-danger">첨부파일 정보 삭제</a>
				</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
				<div class="bordered bg-light fw-bold p-2">파일리스트</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
				<form id="form-file-items" method="get" action="deletefile">
					<input type="hidden" name="fileno" value="${file.no }" />
					<table class="table">
						<colgroup>
							<col width="5%">
							<col width="10%">
							<col width="*">
							<col width="12%">
							<col width="15%">
							<col width="17%">
						</colgroup>
						<thead>
							<tr>
								<th></th>
								<th>순번</th>
								<th>파일명</th>
								<th>파일타입</th>
								<th class="text-end pr-5">파일사이즈</th>
								<th class="text-center"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" varStatus="loop" items="${file.fileItems }">
								<tr>
									<td><input type="checkbox" name="itemno" value="${item.no }"></td>
									<td>${loop.count }</td>
									<td>${item.originalFilename }</td>
									<td>${item.filetype }</td>
									<td class="text-end"><fmt:formatNumber value="${item.filesize }"/> </td>
									<td class="text-center">
										<a class="btn btn-danger btn-sm" href="deletefile?fileno=${file.no }&itemno=${item.no }">삭제</a>
										<a class="btn btn-primary btn-sm" href="download?no=${item.no }">다운로드</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="mt-3">
						<button type="submit" class="btn btn-outline-danger">선택한 파일 삭제</button>
						<button type="button" class="btn btn-outline-primary" id="btn-open-fileitem-modal">파일 추가</button>
					</div>
				</form>
			</div>
		</div>
	</main>
	<div id="modal-add-fileitem" class="modal" tabindex="-1">
  		<div class="modal-dialog">
    		<div class="modal-content">
    			<form id="form-add-fileitem" method="post" action="addfileitem" enctype="multipart/form-data">
	      			<div class="modal-header">
	        			<h5 class="modal-title">파일 추가 모달</h5>
	        			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      			</div>
		      		<div class="modal-body">
		        		<div class="row">
							<div class="col-12 mb-1">
								<span>첨부파일을 등록하세요. </span> 
								<input type="hidden" name="no" value="${file.no }" />
							</div>
							<div class="col-12" id="container-file-field">
								<div class="mb-3">
									<div class="input-group">
										<input type="file" class="form-control" name="upfiles" aria-label="Upload">
									</div>
								</div>
								<div class="mb-3">
									<div class="input-group">
										<input type="file" class="form-control" name="upfiles" aria-label="Upload">
									</div>
								</div>
								<div class="mb-3">
									<div class="input-group">
										<input type="file" class="form-control" name="upfiles" aria-label="Upload">
									</div>
								</div>
							</div>
						</div>
		      		</div>
		      		<div class="modal-footer">
		        		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
		        		<button type="submit" class="btn btn-primary">등록</button>
		      		</div>
	      		</form>
    		</div>
  		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(function() {
	var modalAddFileItem = new bootstrap.Modal(document.getElementById('modal-add-fileitem'), {
		keyboard:false
	});
	
	$("#btn-open-fileitem-modal").click(function() {
		modalAddFileItem.show();
	})
	
	$("#form-file-items").submit(function() {
		var checkboxAmount = $(":checkbox[name=itemno]").length;
		var checkedCheckboxAmount = $(":checkbox[name=itemno]:checked").length;
		
		if (!checkedCheckboxAmount) {
			alert("삭제할 파일을 하나 이상 선택하십시오");
			return false;
		}
		
		if (checkboxAmount == checkedCheckboxAmount) {
			alert("파일 리스트의 모든 파일을 삭제할 수 없습니다.");
			return false;
		}
		return true
	});
	
	$("#form-add-fileitem").submit(function() {
		var hasUploadFiles = false;
		$(":input[name=upfiles]").each(function(index, input) {
			if ($(input).val()) {
				hasUploadFiles = true;
			}
		})
		if (!hasUploadFiles) {
			alert("첨부파일은 최소 한 개 이상 등록되어야 합니다.");
			return false;
		}
		return true;
	});
})
</script>
</body>
</html>