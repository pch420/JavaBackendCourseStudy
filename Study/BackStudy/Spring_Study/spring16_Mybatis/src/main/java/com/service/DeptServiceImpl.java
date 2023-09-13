package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dao.DeptDAO;
import com.dto.DeptDTO;

//@Component("service") // 포괄적인 지정
@Service("service") // 디테일한 지정
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptDAO dao;

	public DeptServiceImpl() {
		System.out.println("DeptServiceImpl 생성자");
	}

	// 스프링에서는 DML 작업시 자동으로 commit 된다.
	@Override
	public List<DeptDTO> deptList() {
		return dao.deptList();
	}

	@Override
	public int deptAdd(DeptDTO dto) {
		return dao.deptAdd(dto);
	}

	@Override
	public int deptUpdate(DeptDTO dto) {
		return dao.deptUpdate(dto);
	}

	@Override
	public int deptDelete(int deptno) {
		return dao.deptDelete(deptno);
	}

}
