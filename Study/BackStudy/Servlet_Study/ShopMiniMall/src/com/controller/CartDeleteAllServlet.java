package com.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.CartService;
import com.service.CartServiceImpl;

@WebServlet("/CartDeleteAllServlet")
public class CartDeleteAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 로그인 여부 확인 방법
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");

		String nextPage = null;
		if (dto != null) {
			// 로그인 한 경우
			String[] check = request.getParameterValues("check");
			List<String> del_list = Arrays.asList(check);

			// del_list 을 서비스 거쳐서 DAO 까지 전달
			CartService service = new CartServiceImpl();
			int n = service.cartDeleteAll(del_list);

			nextPage = "CartListServlet";
		} else {
			// 로그인 안했거나 했는데 time-out된 경우
			nextPage = "member/checkLogin.jsp";
		}
		response.sendRedirect(nextPage);

	}

}
