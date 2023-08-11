package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.EmpDTO;
import com.service.EmpService;
import com.service.EmpServiceImpl;

@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmpService service = new EmpServiceImpl();
		List<EmpDTO> list = service.findAll();

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<meta charset=\"utf-8\">");
		out.print("</head>");
		out.print("<body>");

		out.print("<table border='1'>");
		out.print("<tr>");
		out.print("<th>사원번호</th>");
		out.print("<th>사원이름</th>");
		out.print("<th>월급</th>");
		out.print("<th>입사일</th>");
		out.print("<th>부서번호</th>");
		out.print("</tr>");

		for (EmpDTO dto : list) {
			out.print("<tr>");
			out.print("<td>" + dto.getEmpno() + "</td>");
			out.print("<td>" + dto.getEname() + "</td>");
			out.print("<td>" + dto.getSal() + "</td>");
			out.print("<td>" + dto.getHiredate() + "</td>");
			out.print("<td>" + dto.getDeptno() + "</td>");
			out.print("</tr>");
		}

		out.print("</table>");
		out.print("<a href='member.html'>회원가입화면</a>");		
		out.print("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
