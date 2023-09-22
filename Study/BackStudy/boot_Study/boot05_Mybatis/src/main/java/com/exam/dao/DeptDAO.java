package com.exam.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dto.DeptDTO;

@Repository("deptDAO")
public class DeptDAO {

	@Autowired
	SqlSessionTemplate session;

	// 목록보기
	public List<DeptDTO> deptList() {
		List<DeptDTO> list = session.selectList("DeptMapper.deptList");
		return list;
	}
}
