package com.dto;

public class Cat {

	String username;
	int age;

	public String getUsername() {
		return username;
	}

	// setter 메서드 주입
	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	// setter 메서드 주입
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat [username=" + username + ", age=" + age + "]";
	}

}
