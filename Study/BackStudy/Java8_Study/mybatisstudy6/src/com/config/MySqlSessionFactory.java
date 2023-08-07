package com.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {
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

	// ServiceImpl에 SqlSession 반환하는 메서드
	// new 없이 사용하기 위해서 static으로 지정한다.
	public static SqlSession getSession() {
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
}
