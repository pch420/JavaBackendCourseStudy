package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.DeptDAO;

@Service("xxx")
public class DeptServiceImpl {

	DeptDAO dao;

	public DeptServiceImpl(DeptDAO dao) {
		System.out.println("DeptServiceImpl 생성자로 자동 주입");
		this.dao = dao;
	}

	public List<String> list() {
		return dao.list();
	}

}
