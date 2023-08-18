<%@page import="com.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			
			// button 이벤트 추가
			$("button").on("click",function(){
				var num = $(this).attr("data-num")
				location.href="delete?num=" + num;
			});
		});
	
	</script>
</head>
<body>
	<h2>게시판 목록보기</h2>
	<%
		List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("boardList");
	%>
	<table border="1">
	<!-- 검색 화면 -->
	<tr>
	<td colspan="6">
	<form action="list">
	<select name="searchName">
		<option value="title">제목</option>
		<option value="author">작성자</option>	
	</select>
	<input type="text" name="searchValue">
	<input type="submit" value="검색">
	</form>
	</td>
	</tr>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>삭제</th>
		</tr>
		<%
			for (BoardDTO dto : list) {
			int num = dto.getNum();
			String title = dto.getTitle();
			String author = dto.getAuthor();
			String writeday = dto.getWriteday();
		%>
		<tr>
			<td><%=num%></td>
			<td><a href="retrieve?num=<%=num%>"><%=title%></a></td>
			<td><%=author%></td>
			<td><%=writeday%></td>
			<td><%=dto.getReadcnt()%></td>
			<td><button data-num="<%= num %>">삭제</button></td>
		</tr>
		<%
			}
		%>

	</table>
	<a href="writeui">글쓰기</a>
</body>
</html>