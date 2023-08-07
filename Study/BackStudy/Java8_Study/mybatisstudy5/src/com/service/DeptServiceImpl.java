package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.DeptDAO;
import com.dto.DeptDTO;

public class DeptServiceImpl implements DeptService {

	static SqlSessionFactory sqlSessionFactory = null;

	static { // 생성자 또는 메서드보다 빨리 실행됨
		// Configuration.xml 파일읽기
		String resource = "com/config/Configuration.xml"; // 패키지로 되어 있을때 java와 달리 /로 구분해야함
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	} // end static 블럭

	@Override
	public List<DeptDTO> findAll() {
		List<DeptDTO> list = null;
		// SqlSession 얻기, DAO 연동, close 는 JDBC에서도 사용한 구조
		// 1. SqlSession 얻기
		SqlSession session = sqlSessionFactory.openSession();
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
		SqlSession session = sqlSessionFactory.openSession();
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
		SqlSession session = sqlSessionFactory.openSession();
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
		SqlSession session = sqlSessionFactory.openSession();
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
		SqlSession session = sqlSessionFactory.openSession();
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
