package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.CartServiceImpl;
import com.service.OrderService;
import com.service.OrderServiceImpl;

@WebServlet("/OrderComfirmServlet")
public class OrderComfirmServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 로그인 여부 확인 방법
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");

		String nextPage = null;
		if (dto != null) {
			// 로그인 한 경우
			String num = request.getParameter("num");
			OrderService service = new OrderServiceImpl();

			// num 값에 해당하는 CartDTO 얻기
			CartDTO cDTO = service.cartByNum(Integer.parseInt(num));

			// userid 값에 해당하는 MemberDTO 얻기
			String userid = dto.getUserid();
			MemberDTO mDTO = service.memberByUserid(userid);

			// scope에 저장
			request.setAttribute("cDTO", cDTO);
			request.setAttribute("mDTO", mDTO);

			// 요청 위임
			nextPage = "orderConfirm.jsp";
		} else {
			// 로그인 안했거나 했는데 time-out된 경우
			nextPage = "member/checkLogin.jsp";
		}

		request.getRequestDispatcher(nextPage).forward(request, response);

	}

}
