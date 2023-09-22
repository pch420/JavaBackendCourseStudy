package com.exam.service;

import org.springframework.stereotype.Service;

@Service("xxx")
public class UserService {
	
	// 핵심처리 메서드
	public String sayEcho() {
		System.out.println("sayEcho");
		return "hello";
	}
}
