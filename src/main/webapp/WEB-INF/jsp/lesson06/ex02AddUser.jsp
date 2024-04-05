<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		<div class="form-group">
			<label for="name">이름</label>
			
			<div class="d-flex">
				<input type="text" id="name" name="name" class="form-control col-4">
				<button type="button" id="nameCheckBtn" class="btn btn-warning">중복확인</button>
			</div>
			
			<small id="nameStatusArea"></small>
		</div>
		<input type="button" value="회원가입" id="joinBtn" class="btn btn-info">
	</div>
	
	<script>
		$(document).ready(function() {
			// 중복확인 버튼 클릭
			$("#nameCheckBtn").on('click', function() {
				//alert("중복확인");
				let name = $("#name").val().trim();
				
				// validation
				if (!name) {
					alert("이름을 입력하세요");
					return;
				}
			});
		});
	</script>
</body>
</html>