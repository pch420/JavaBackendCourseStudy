package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myLogin")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("</head>");
		out.print("<body>");

		out.print("이름은 " + userid + "이고 비밀번호는 " + passwd);

		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
