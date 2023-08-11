package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.EmpDTO;

public class EmpDAO {

	public List<EmpDTO> findAll(SqlSession session) {
		List<EmpDTO> list = session.selectList("EmpMapper.findAll");
		return list;
	}

	public int addEmp(SqlSession session, HashMap<String, Object> map) {
		int n = session.insert("EmpMapper.addEmp", map);
		return n;
	}

}
