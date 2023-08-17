<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--위치는 중요하지 않음--%>
<%--declaration_tag와 달리 멤버 메서드 선언 등은 할 수 없음--%>
<%--doGet(doPost)에서 할 수 있는 작업은 다 할 수 있음--%>
<%
	// scriptlet tag
	int num = 0;
	if(num==0){
		System.out.println("num==0");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// scriptlet tag
	int num2 = 10;
	for(int i = 0; i<5; i++){
		System.out.println("hello");
	}
%>
</body>
</html>
