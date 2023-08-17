package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/list")
public class BoardListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// BoardService 연동
		BoardService service = new BoardServiceImpl();
		List<BoardDTO> list = service.list();

		// 이전에는 서블릿에서 응답처리를 했음. ==> list.jsp 위임
		// list.jsp에서 List<BoardDTO> 보여주기 위해서는
		// List<BoardDTO>를 scope에 저장해야 됨.
		// 목록보기는 request scope가 가장 최적임. (보여주고 삭제되도 되므로)

		request.setAttribute("boardList", list);

		// 요청위임 ==> request scope에 저장했기 때문에 포워드(forward)방식으로 사용해야 함.
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
