package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("</head>");
		out.print("<body>");
		
		out.print("<table border='1'>");		
		out.print("<tr>");
		out.print("<td>이름</td>");		
		out.print("<td>나이</td>");		
		out.print("<td>주소</td>");		
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>홍길동</td>");		
		out.print("<td>20</td>");		
		out.print("<td>서울</td>");		
		out.print("</tr>");
		out.print("</table>");
		
		out.print("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("uft-8");
		doGet(request, response);
	}

}
