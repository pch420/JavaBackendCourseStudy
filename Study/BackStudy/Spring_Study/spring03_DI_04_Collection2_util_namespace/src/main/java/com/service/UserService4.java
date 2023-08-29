package com.service;

import java.util.Properties;

public class UserService4 {

	// 순서가 없음, 중복 불가
	Properties phones;

	public Properties getPhones() {
		return phones;
	}

	// setter 메서드 의존성 주입
	public void setPhones(Properties phones) {
		this.phones = phones;
	}

}
