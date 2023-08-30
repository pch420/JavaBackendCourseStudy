package com.dto;

import org.springframework.beans.factory.annotation.Value;

public class Cat {
	@Value(value = "홍길동")
	String username;

	@Value("10") // @Value에서 value는 생략가능, 문자열로 입력할 것
	int age;

	public Cat() {
	}

	public Cat(String username, int age) {
		this.username = username;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat [username=" + username + ", age=" + age + "]";
	}

}
