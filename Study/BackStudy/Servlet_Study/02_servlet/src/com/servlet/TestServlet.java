package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	// ServletConfig는 servlet 당 하나씩 생성되므로 공유 x
	// TestServlet의 ServletConfig를 ExamServlet에서 공유해서 사용 x
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("TestServlet" + getServletName());
		// ServletConfig의 getInitParameter(name)
		String dir_path = getInitParameter("dir_path");
		String email = getInitParameter("email");
		System.out.println(dir_path + "\t" + email);

		// ServletContext의 getInitParameter(name)
		ServletContext ctx = getServletContext();
		String userid = ctx.getInitParameter("userid");
		String passwd = ctx.getInitParameter("passwd");
		System.out.println(userid + "\t" + passwd);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
