package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.DeptDTO;
import com.service.DeptService;
import com.service.DeptServiceImpl;

@WebServlet("/update")
public class DeptUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request 는 문자로 받아옴.
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");

		HashMap<String, Object> map = new HashMap<>();
		map.put("deptno", deptno);
		map.put("dname", dname);
		map.put("loc", loc);

		// 서비스 연동
		DeptService service = new DeptServiceImpl();
		int n = service.updateDept(map);

		if (n == 1) {
			response.sendRedirect("list");
		} else {
			response.sendRedirect("retrieve?deptno=" + deptno);
		}
		// 응답처리
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print("<html><head>");
//		out.print("<meta charset=\"UTF-8\">");
//		out.print("<title>Insert title here</title>");
//		out.print("</head>");
//		out.print("<body>");
//
//		if (n == 1) {
//			out.print("부서수정 성공<br>");
//			out.print("<a href='list'>목록보기</a><br>");
//		} else {
//			out.print("부서수정 실패<br>");
//			out.print("<a href='retrieve?deptno=" + deptno + "'>부서정보</a><br>");
//		}
//
//		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 한글처리 ==> 나중에 필터로 구현
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
