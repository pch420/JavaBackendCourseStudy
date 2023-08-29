package com.service;

public class UserService {

	public UserService() {
		System.out.println("UserService 생성자");
	}

	// init-method="xxx"
	public void xxx() {
		System.out.println("생성자 호출후 xxx 호출");
	}

	// destroy-method="yyy"
	public void yyy() {
		System.out.println("yyy 호출");
	}
}
