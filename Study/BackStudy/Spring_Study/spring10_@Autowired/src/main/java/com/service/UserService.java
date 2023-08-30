package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.UserDAO;

public class UserService {

	@Autowired // 변수의 타입인 UserDAO를 user.xml에서 찾아서 주입함
	UserDAO dao;

	/*- 변수에 @Autowired를 통해 주입했기 때문에 더이상 생성자, set 메서드가 필요x - 코드가 간결해짐
		public UserService() {
		}
	
	//	@Autowired // 생성자의 파라미터 타입인 UserDAO를 user.xml에서 찾아서 주입함
		public UserService(UserDAO dao) {
			System.out.println("UserService(UserDAO dao)");
			this.dao = dao;
		}
	
	//	@Autowired // 메서드의 파라미터 타입인 UserDAO를 user.xml에서 찾아서 주입함
		public void setDAO(UserDAO dao) {
			System.out.println("setDAO(UserDAO dao)");
			this.dao = dao;
	//	}
	*/
	public List<String> list() {
		return dao.list();
	}
}
