package com.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.dao.DeptDAO;
import com.exam.dto.DeptDTO;

@Service("xxx")
public class DeptServiceImpl implements DeptService {

	DeptDAO dao;
	// 기본 생성자 제거 필수

	public DeptServiceImpl(DeptDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<DeptDTO> deptList() {
		return dao.deptList();
	}
}
