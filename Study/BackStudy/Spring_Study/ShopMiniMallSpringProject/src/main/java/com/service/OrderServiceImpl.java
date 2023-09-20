package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.OrderDAO;
import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO dao;

	@Override
	public CartDTO cartByNum(int num) {
		CartDTO cartDTO = dao.cartByNum(num);
		return cartDTO;
	}

	@Override
	public MemberDTO memberByUserid(String userid) {
		MemberDTO memberDTO = dao.memberByUserid(userid);
		return memberDTO;
	}

	@Override
	@Transactional // dao.orderDone()와 dao.cartDel() 모두 성공하면 자동으로 commit 되고, 하나라도 런타임예외가 발생시 모두 rollback됨
	public int orderDone(OrderDTO dto, int del_num) {
		int n = dao.orderDone(dto);
			n = dao.cartDel(del_num);
		return n;
	}

}
