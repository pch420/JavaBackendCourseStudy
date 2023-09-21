package com.exam.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class DeptDAO {

	public DeptDAO() {
		System.out.println("DeptDAO 생성");
	}

	public List<String> list() {
		return Arrays.asList("홍길동", "이순신");
	}

}
