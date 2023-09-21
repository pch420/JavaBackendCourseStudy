package com.exam.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DeptDAO {

	public DeptDAO() {
		// Application.java 와 같거나 하위 패키지로 만들면 자동으로 component-scan 해줌
		System.out.println("DeptDAO 생성");
	}

}
