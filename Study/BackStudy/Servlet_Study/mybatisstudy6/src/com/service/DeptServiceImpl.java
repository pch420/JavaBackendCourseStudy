package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.DeptDAO;
import com.dto.DeptDTO;

public class DeptServiceImpl implements DeptService {

	@Override
	public List<DeptDTO> findAll() {
		List<DeptDTO> list = null;
		// SqlSession 얻기, DAO 연동, close 는 JDBC에서도 사용한 구조
		// 1. SqlSession 얻기
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			////////////////////////////////////
			// 2. DAO 연동
			DeptDAO dao = new DeptDAO();
			list = dao.findAll(session);
			////////////////////////////////////
		} finally {
			// 3. close
			session.close();
		}
		return list;
	}

	@Override
	public DeptDTO findByDeptno(int deptno) {
		DeptDTO dto = null;
		// 1. SqlSession 얻기
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			// 2. DAO 연동
			DeptDAO dao = new DeptDAO();
			dto = dao.findByDeptno(session, deptno);
		} finally {
			// 3. close
			session.close();
		}
		return dto;
	}

	@Override
	public int addDept(DeptDTO dto) {
		int n = 0;
		// 1. SqlSession 얻기
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			// 2. DAO 연동
			DeptDAO dao = new DeptDAO();
			n = dao.addDept(session, dto);
			session.commit(); // 명시적 commit
		} finally {
			// 3. close
			session.close();
		}
		return n;
	}

	@Override
	public int updateDept(HashMap<String, Object> map) {
		int n = 0;
		// 1. SqlSession 얻기
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			// 2. DAO 연동
			DeptDAO dao = new DeptDAO();
			n = dao.updateDept(session, map);
			session.commit(); // 명시적 commit
		} finally {
			// 3. close
			session.close();
		}
		return n;
	}

	@Override
	public int deleteDept(int deptno) {
		int n = 0;
		// 1. SqlSession 얻기
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			// 2. DAO 연동
			DeptDAO dao = new DeptDAO();
			n = dao.deleteDept(session, deptno);
			session.commit(); // 명시적 commit
		} finally {
			// 3. close
			session.close();
		}
		return n;
	}
}
