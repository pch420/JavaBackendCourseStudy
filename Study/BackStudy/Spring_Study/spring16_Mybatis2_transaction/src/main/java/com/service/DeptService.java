package com.service;

import java.util.List;

import com.dto.DeptDTO;

public interface DeptService {
	public List<DeptDTO> deptList();

	public int deptAdd(DeptDTO dto);

	public int deptUpdate(DeptDTO dto);

	public int deptDelete(int deptno);
	
	// 트랜잭션 실습
	public int tx();
}
