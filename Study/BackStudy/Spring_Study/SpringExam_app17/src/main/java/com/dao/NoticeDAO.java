package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.NoticeDTO;
import com.dto.PageDTO;

@Repository("dao")
public class NoticeDAO {

	@Autowired
	SqlSessionTemplate session;

	// 목록보기
	public PageDTO list(int curPage) {
		PageDTO pageDTO = new PageDTO();

		int offset = (curPage - 1) * pageDTO.getPerPage(); // 시작위치
		int limit = pageDTO.getPerPage(); // 한 페이지당 보여줄 레코드 갯수
		List<NoticeDTO> list = session.selectList("NoticeMapper.list", null,new RowBounds(offset, limit));

		// list 저장
		pageDTO.setList(list);

		// curPage 저장
		pageDTO.setCurPage(curPage);

		// totalCount 저장
		int totalCount = session.selectOne("totalCount");
		pageDTO.setTotalCount(totalCount);
		
		return pageDTO;
	}

	// 글저장
	public int write(NoticeDTO dto) {
		int n = session.insert("NoticeMapper.write", dto);
		return n;
	}

	// 글 자세히 보기
	public NoticeDTO retrieve(int no) {
		NoticeDTO dto = session.selectOne("NoticeMapper.retrieve", no);
		return dto;
	}

	// 글 자세히 보기 - 조회수 증가
	public int readcnt(int no) {
		int n = session.update("NoticeMapper.readcnt", no);
		return n;
	}

	// 글 수정
	public int update(NoticeDTO dto) {
		int n = session.update("NoticeMapper.update", dto);
		return n;
	}

	// 글 삭제
	public int delete(int no) {
		int n = session.update("NoticeMapper.delete", no);
		return n;
	}
}
