package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.DeptDTO;

//@Component("dao") // 포괄적인 지정
@Repository("dao") // 디테일한 지정
public class DeptDAO {

	@Autowired
	SqlSessionTemplate session;

	public List<DeptDTO> findAll() {
		return session.selectList("DeptMapper.findAll");
	}

}
