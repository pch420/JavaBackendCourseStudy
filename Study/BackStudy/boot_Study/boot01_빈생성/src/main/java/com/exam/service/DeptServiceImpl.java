package com.exam.service;

import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl {

	public DeptServiceImpl() {
		// Application.java 와 같거나 하위 패키지로 만들면 자동으로 component-scan 해줌
		System.out.println("DeptServiceImpl 생성");
	}

}
