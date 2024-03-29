package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardDAO;
import com.dto.BoardDTO;
import com.dto.PageDTO;

public class BoardServiceImpl implements BoardService {

	@Override
	public PageDTO list(HashMap<String, String> map, int curPage) {
		PageDTO pageDTO = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			// DAO 연동코드
			BoardDAO dao = new BoardDAO();
			pageDTO = dao.list(session, map, curPage);

		} finally {
			session.close();
		}
		return pageDTO;
	}

	@Override
	public int write(BoardDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			// DAO 연동코드
			BoardDAO dao = new BoardDAO();
			n = dao.write(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	@Override
	public BoardDTO retrieve(int num) {
		BoardDTO dto = null;
		int n = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			// DAO 연동코드
			BoardDAO dao = new BoardDAO();
			// 조회수 증가
			n = dao.readcnt(session, num);
			session.commit();
			// 글 자세히 보기
			dto = dao.retrieve(session, num);
		} finally {
			session.close();
		}
		return dto;
	}

	@Override
	public int update(BoardDTO dto) {
		int n = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			// DAO 연동코드
			BoardDAO dao = new BoardDAO();
			// 글 수정
			n = dao.update(session, dto);
			session.commit();

		} finally {
			session.close();
		}
		return n;
	}

	@Override
	public int delete(int num) {
		int n = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			//DAO 연동코드
			BoardDAO dao = new BoardDAO();
			// 글 삭제
			n = dao.delete(session, num);
			session.commit();
		} finally {
			session.close();
		}
		return n;
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
