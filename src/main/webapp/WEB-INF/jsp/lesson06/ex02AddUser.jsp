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
				// nameStatusArea 하위 태그들 초기화
				$("#nameStatusArea").empty(); // 자식 태그들을 모두 비운다.
				
				//alert("중복확인");
				let name = $("#name").val().trim();
				
				// validation
				if (!name) {
					$("#nameStatusArea").append('<span class="text-danger">이름이 비어있습니다.</span>');
					return;
				}
				
				// AJAX - 이름 중복 확인 DB에서
				$.ajax({
					// request
					type:"GET" // get일 때 생략 가능
					, url:"/lesson06/ex02/is-duplication-name"
					, data:{"name":name}
					
					// response
					, success:function(data) { // string->parsing=>dictionary
						// {"code":200, "is_duplication":true}
						// 중복일 때 문구 노출
						if (data.is_duplication) {
							$("#nameStatusArea").append('<span class="text-danger">중복된 이름입니다.</span>');
						}
					}
					, error:function(error) {
						alert("이름 중복확인에 실패했습니다.");
					}
				});
			});
			
			// 회원가입
			$("#joinBtn").on('click', function() {
				//alert("회원가입");
				
				// nameStatusArea에 자식태그가 아무것도 없다면 가입
				console.log($("#nameStatusArea").children());
				
				if ($("#nameStatusArea").children().length < 1) {
					alert("회원가입 진행");
				} else {
					alert("회원가입 불가");
				}
				
			})
			
		});
	</script>
</body>
</html>