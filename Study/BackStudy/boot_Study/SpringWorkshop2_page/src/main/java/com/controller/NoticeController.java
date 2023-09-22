package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Notice;
import com.dto.PageDTO;
import com.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	NoticeService service;

	// 1. 글쓰기 화면 보기
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeUI() {
		return "writeForm";
	}

	// 2. 글쓰기
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Notice notice) {
		int num = service.noticeWrite(notice);
		return "redirect:list";
	}

	// 3.목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ModelAttribute("pageDTO")
	public PageDTO list(@RequestParam(value = "curPage", required = false, defaultValue = "1") int curPage) {
		return service.selectList(curPage);
	}

	// 4. 글자세히 보기
	@RequestMapping(value = "/retrieve", method = RequestMethod.GET)
	@ModelAttribute("retrieve")
	public Notice retrieve(int no) {
		Notice notice = service.selectByNo(no);
		return notice;
	}

	// 5. 글 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Notice notice) {
		int num = service.noticeUpdate(notice);
		return "redirect:list";
	}

	// 6. 글 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int no) {
		int num = service.noticeDelete(no);
		return "redirect:list";
	}
}
