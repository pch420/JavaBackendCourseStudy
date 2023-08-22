<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- top.jsp -->
<!-- EL, JSTL로 변경 -->

<c:if test="${login==null}">
	<a href="LoginUIServlet">로그인</a>
	<a href="MemberUIServlet">회원가입</a>
</c:if>

<c:if test="${login!=null}">
안녕하세요${login.username}<br>
	<a href="">로그아웃</a>
	<a href="">mypage</a>
	<a href="">장바구니목록</a>
</c:if>