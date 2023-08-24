package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;

public class CartDAO {

	// 장바구니 저장
	public int cartAdd(SqlSession session, CartDTO dto) {
		int n = session.insert("CartMapper.cartAdd", dto);
		return n;
	}

	// 장바구니 목록
	public List<CartDTO> cartList(SqlSession session, String userid) {
		List<CartDTO> list = session.selectList("CartMapper.cartList", userid);
		return list;
	}

	// 수량 수정
	public int cartUpdate(SqlSession session, HashMap<String, Integer> map) {
		int n = session.update("CartMapper.cartUpdate", map);
		return n;
	}

	// 단일 삭제
	public int cartDelete(SqlSession session, int num) {
		int n = session.delete("CartMapper.cartDelete", num);
		return n;
	}

	// 전체 삭제
	public int cartDeleteAll(SqlSession session, List<String> num) {
		int n = session.delete("CartMapper.cartDeleteAll", num);
		return n;
	}

}
