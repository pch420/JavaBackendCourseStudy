package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.NoticeDTO;
import com.dto.PageDTO;
import com.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	NoticeService service;

	// 전체목록
	@GetMapping("/list")
	public String list(Model m, HttpServletRequest request) {

		String curPage = request.getParameter("curPage");
		if (curPage == null) {
			curPage = "1";
		}
		PageDTO pageDTO = service.list(Integer.parseInt(curPage));
		m.addAttribute("PageDTO", pageDTO);
		return "list";
	}

	// 글쓰기 화면
	@GetMapping("/write")
	public String writeForm() {
		return "writeForm";
	}

	// 글쓰기
	@PostMapping("/write")
	public String write(NoticeDTO dto) {
		service.write(dto);
		return "redirect:list";
	}

	// 자세히보기
	@GetMapping("/retrieve")
	public String findOne(@RequestParam int no, Model m) {
		NoticeDTO dto = service.retrieve(no);

		m.addAttribute("dto", dto);
		return "retrieve";
	}

	// 글 수정
	@PostMapping("/update")
	public String update(NoticeDTO dto) {
		service.update(dto);
		return "redirect:list";
	}

	// 글 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam int no) {
		service.delete(no);
		return "redirect:list";
	}

}
