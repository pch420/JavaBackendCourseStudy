package com.dao;

import java.util.Arrays;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("dao") // 포괄적인 지정
@Repository("dao") // 디테일한 지정
public class DeptDAO {
	public List<String> list() {
		return Arrays.asList("홍길동", "이순신");
	}

	public DeptDAO() {
		System.out.println("DeptDAO 생성자");
	}

}
