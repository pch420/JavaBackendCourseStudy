package com.service;

import java.util.HashMap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartDAO;
import com.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDAO dao;

	@Override
	public int cartAdd(CartDTO dto) {
		int n = dao.cartAdd(dto);
		return n;
	}

	@Override
	public List<CartDTO> cartList(String userid) {
		List<CartDTO> list = dao.cartList(userid);
		return list;
	}

	@Override
	public int cartUpdate(HashMap<String, Integer> map) {
		int n = dao.cartUpdate(map);
		return n;
	}

	@Override
	public int cartDelete(int num) {
		int n = dao.cartDelete(num);
		return n;
	}

	@Override
	public int cartDeleteAll(List<String> num) {
		int n = dao.cartDeleteAll(num);
		return n;
	}

	/*-
	 *	SqlSession session = MySqlSessionFactory.getSession();
		try {
			// DAO 연동
			CartDAO dao = new CartDAO();
			n = dao.cartUpdate(session, map);
			session.commit();
		} finally {
			session.close();
		}
	 * 
	 * 
	 */

}
