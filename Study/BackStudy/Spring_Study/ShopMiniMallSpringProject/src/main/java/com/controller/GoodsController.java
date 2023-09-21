package com.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	GoodsService service;

	@Autowired
	CartService cartService;

	@GetMapping("/goodsRetrieve") // /WET-INF/shop/goodsRetrieve.jsp
	@ModelAttribute("goodsRetrieve")
	public GoodsDTO goodsRetrieve(@RequestParam("gCode") String gCode) {
		GoodsDTO dto = service.goodsRetrieve(gCode); // 모델
		return dto; // key값 : goodsRetrieve, value값 : dto
	}

	@GetMapping("/CartAddServlet")
	public String cartAdd(HttpSession session, CartDTO cartDTO) {
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String userid = dto.getUserid();
		cartDTO.setUserid(userid);
		int n = cartService.cartAdd(cartDTO); // 모델
		return "goods/cartAddSuccess"; // 뷰
	}

	@GetMapping("/CartListServlet")
	public ModelAndView cartList(HttpSession session) {
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String userid = dto.getUserid();
		List<CartDTO> list = cartService.cartList(userid); // 모델

		ModelAndView mav = new ModelAndView();
		mav.addObject("cartList", list); // 모델 저장
		mav.setViewName("cartList"); // 뷰 저장
		return mav; // 뷰
	}

	@GetMapping("/CartUpdateServlet")
	@ResponseBody // 뷰를 찾지 않게함
	public void cartUpdate(@RequestParam HashMap<String, Integer> map) {
		int n = cartService.cartUpdate(map);
	}

	@GetMapping("/CartDeleteServlet")
	public String cartDelete(@RequestParam("num") int num) { // String -> int 자동 형변환 가능함
		int n = cartService.cartDelete(num);
		return "redirect:CartListServlet";
	}

	@GetMapping("/CartDeleteAllServlet")
	public String cartDeleteAll(HttpServletRequest request) {
		String[] check = request.getParameterValues("check");
		List<String> del_list = Arrays.asList(check);
		int n = cartService.cartDeleteAll(del_list);
		return "redirect:CartListServlet";
	}
}
