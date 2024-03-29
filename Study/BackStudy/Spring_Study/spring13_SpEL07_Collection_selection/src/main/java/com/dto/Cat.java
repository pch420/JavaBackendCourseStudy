package com.dto;

public class Cat {

	String username;
	int age;
	boolean isMarried;
	double height;

	public Cat() {
	}

	public Cat(String username, int age, boolean isMarried, double height) {
		this.username = username;
		this.age = age;
		this.isMarried = isMarried;
		this.height = height;
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

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Person [username=" + username + ", age=" + age + ", isMarried=" + isMarried + ", height=" + height
				+ "]";
	}

}
