package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsDAO;
import com.dto.GoodsDTO;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsDAO dao;

	@Override
	public List<GoodsDTO> goodsList(String gCategory) {
		List<GoodsDTO> list = dao.goodsList(gCategory);
		return list;
	}

	@Override
	public GoodsDTO goodsRetrieve(String gCode) {
		GoodsDTO dto = dao.goodsRetrieve(gCode);
		return dto;
	}

	/*-
	 * 		SqlSession session = MySqlSessionFactory.getSession();
			try {
				// DAO 연동
				GoodsDAO dao = new GoodsDAO();
			
			} finally {
				session.close();
			}
	 * 
	 */
}
