package com.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.CartDTO;

@Repository
public class CartDAO {
	
	@Autowired
	SqlSessionTemplate session;

	// 장바구니 저장
	public int cartAdd(CartDTO dto) {
		int n = session.insert("CartMapper.cartAdd", dto);
		return n;
	}

	// 장바구니 목록
	public List<CartDTO> cartList(String userid) {
		List<CartDTO> list = session.selectList("CartMapper.cartList", userid);
		return list;
	}

	// 수량 수정
	public int cartUpdate(HashMap<String, Integer> map) {
		int n = session.update("CartMapper.cartUpdate", map);
		return n;
	}

	// 단일 삭제
	public int cartDelete(int num) {
		int n = session.delete("CartMapper.cartDelete", num);
		return n;
	}

	// 전체 삭제
	public int cartDeleteAll(List<String> num) {
		int n = session.delete("CartMapper.cartDeleteAll", num);
		return n;
	}

}
