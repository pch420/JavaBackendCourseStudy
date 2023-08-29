package com.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UserService3 {

	public UserService3() {
		System.out.println("UserService 생성자");
	}

	@PostConstruct
	public void xxx() {
		System.out.println("@PostConstruct.xxx");
	}

	@PreDestroy
	public void yyy() {
		System.out.println("@PreDestroy.yyy");
	}

}
