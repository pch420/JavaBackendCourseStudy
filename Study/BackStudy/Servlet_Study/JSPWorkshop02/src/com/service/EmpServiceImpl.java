package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.EmpDAO;
import com.dto.EmpDTO;

public class EmpServiceImpl implements EmpService {

	@Override
	public List<EmpDTO> findAll() {
		List<EmpDTO> list = null;
		// SqlSession 얻기

		SqlSession session = MySqlSessionFactory.getSession();
		try {
			//////////////////////////
			// DAO 연동
			EmpDAO dao = new EmpDAO();
			list = dao.findAll(session);
			//////////////////////////
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int addEmp(HashMap<String, Object> map) {
		int n = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			EmpDAO dao = new EmpDAO();
			n = dao.addEmp(session, map);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}


	/*-
	 * SqlSession session = sqlSessionFactory.openSession();
		try {
	
		} finally {
			session.close();
		}
	 */
}
