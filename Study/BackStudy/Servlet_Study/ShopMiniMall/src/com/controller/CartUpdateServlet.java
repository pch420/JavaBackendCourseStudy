package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CartDAO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.CartServiceImpl;

@WebServlet("/CartUpdateServlet")
public class CartUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 로그인 여부 확인 방법
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");

		if (dto != null) {
			// 로그인 한 경우
			String num = request.getParameter("num");
			String gAmount = request.getParameter("gAmount");

			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("num", Integer.parseInt(num));
			map.put("gAmount", Integer.parseInt(gAmount));

			// map을 서비스 거쳐서 DAO에 전달
			CartService service = new CartServiceImpl();
			int n = service.cartUpdate(map);

			// ajax 이기 때문에 화면처리 불필요 (-> cartList.jsp의 success로 감)

		} else {
			// 로그인 안했거나 했는데 time-out된 경우
			response.sendRedirect("member/checkLogin.jsp");
		}

	}

}
