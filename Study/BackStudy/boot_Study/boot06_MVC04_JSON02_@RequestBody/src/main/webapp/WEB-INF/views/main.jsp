<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		//yyy이벤트  "json"--> LoginDTO
		$("#yyy").on("click", function() {
			//ajax
			$.ajax({
				url : 'yyy',
				type : "post",
				dataType : "text", //응답데이터 타입
				headers : { // 요청 데이터 타입
					"Content-Type" : "application/json"
				},
				data : JSON.stringify({
					userid : "홍길동",
					passwd : "1234"
				}),
				success : function(data, status, xhr) {
					console.log(data);
				},
				error : function(xhr, status, error) {

				}
			});//end ajax
		});//end yyy

		//zzz 이벤트  "json"--> LoginDTO
		$("#zzz").on("click", function() {
			//ajax
			$.ajax({
				url : 'zzz',
				type : "post",
				dataType : "text", //응답데이터 타입
				headers : { // 요청 데이터 타입
					"Content-Type" : "application/json"
				},
				data : JSON.stringify([ {
					userid : "홍길동1",
					passwd : "1234"
				}, {
					userid : "홍길동2",
					passwd : "9999"
				} ]),
				success : function(data, status, xhr) {
					console.log(data);
				},
				error : function(xhr, status, error) {

				}
			});//end ajax
		});//end yyy

	});//end ready
</script>
</head>
<body>
	<h1>main.jsp</h1>
</body>
<button id="yyy">yyy</button>
<br>
<button id="zzz">zzz</button>
<br>
</html>