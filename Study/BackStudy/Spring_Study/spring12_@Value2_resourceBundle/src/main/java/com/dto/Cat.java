package com.dto;

import org.springframework.beans.factory.annotation.Value;

public class Cat {
	@Value(value = "${cat.username}")
	String username;

	@Value("${cat.age}")
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
