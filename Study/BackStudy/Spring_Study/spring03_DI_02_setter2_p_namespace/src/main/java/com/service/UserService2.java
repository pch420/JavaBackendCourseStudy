package com.service;

public class UserService2 {
	int num;
	String username;

	// setter 메서드 이용한 의존성 주입
	public void setNum(int num) {
		System.out.println("setNum 메서드");
		this.num = num;
	}

	// setter 메서드 이용한 의존성 주입
	public void setUsername(String username) {
		System.out.println("setUsername 메서드");
		this.username = username;
	}

	public int getNum() {
		return num;
	}

	public String getUsername() {
		return username;
	}
}
