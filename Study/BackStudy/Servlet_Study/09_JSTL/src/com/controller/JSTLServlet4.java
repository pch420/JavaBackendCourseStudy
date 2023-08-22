package com.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.LoginDTO;

/**
 * Servlet implementation class ELServlet
 */
@WebServlet("/JSTLServlet4")
public class JSTLServlet4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//scope에 저장
		// list 생성후 scope에 저장
				List<LoginDTO> list = 
						Arrays.asList(new LoginDTO("asdf1", "1234"),
								      new LoginDTO("asdf2", "6754"),
								      new LoginDTO("asdf3", "9999"),
								      new LoginDTO("asdf4", "8888"),
								      new LoginDTO("asdf5", "777"));
				
				request.setAttribute("list", list);
		
		
		//요청위임
		request.getRequestDispatcher("04_iterate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
