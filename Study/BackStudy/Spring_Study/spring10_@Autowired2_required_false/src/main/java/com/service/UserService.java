package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.UserDAO;

public class UserService {

	@Autowired(required = false) // 변수의 타입인 UserDAO를 user.xml에서 찾아서 주입함
	UserDAO dao;

	public List<String> list() {
		return dao.list();
	}
}
