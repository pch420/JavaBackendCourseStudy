package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmpService;
import com.service.EmpServiceImpl;

@WebServlet("/EmpAddServlet")
public class EmpAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// (empno, ename, job, mgr, hiredate, sal, deptno, comm)
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		String mgr = request.getParameter("mgr");
		String sal = request.getParameter("sal");

		// (#{empno}, #{ename}, #{job}, #{mgr}, sysdate, #{sal})
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("empno", empno);
		map.put("ename", ename);
		map.put("job", job);
		map.put("mgr", mgr);
		map.put("sal", sal);

		// 서비스 연동
		EmpService service = new EmpServiceImpl();
		int n = service.addEmp(map);
		System.out.println(map);

		// 응답처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");

		if (n == 1) {
			out.print("회원가입성공");
			out.print("<a href='EmpListServlet'>목록보기</a><br>");
		} else {
			out.print("회원가입실패");
			out.print("<a href='member.html'>사원 등록</a><br>");
		}

		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
