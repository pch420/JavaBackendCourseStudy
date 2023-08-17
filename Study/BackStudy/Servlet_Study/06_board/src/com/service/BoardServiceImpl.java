package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardDAO;
import com.dto.BoardDTO;

public class BoardServiceImpl implements BoardService {

	@Override
	public List<BoardDTO> list() {
		List<BoardDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			// DAO 연동코드
			BoardDAO dao = new BoardDAO();
			list = dao.list(session);

		} finally {
			session.close();
		}
		return list;
	}
	/*-
	 * 		SqlSession session = MySqlSessionFactory.getSession();
			try {
				//DAO 연동코드
			} finally {
				session.close();
			}
	 * 
	 */
}
