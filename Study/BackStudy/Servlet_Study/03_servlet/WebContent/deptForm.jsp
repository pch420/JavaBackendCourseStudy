<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서등록</title>
</head>
<body>
	<h2>부서입력</h2>
	<form action="write" method="post">
		부서번호 : <input type="text" name="deptno"><br> 
		부서명 : <input type="text" name="dname"><br> 
		부서위치 : <input type="text" name="loc"><br> 
		<input type="submit" value="저장">
	</form>
</body>
</html>