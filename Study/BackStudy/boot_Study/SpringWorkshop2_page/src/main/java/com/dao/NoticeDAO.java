package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Notice;
import com.dto.PageDTO;

@Repository
public class NoticeDAO {

	
	@Autowired
	SqlSessionTemplate session;
	
	public int totalCount() {
		return session.selectOne("NoticeMapper.totalCount");
	}
	
	public PageDTO selectList(int curPage) {
		PageDTO pageDTO = new PageDTO();
		int offset = (curPage-1)*pageDTO.getPerPage();
		int limit = pageDTO.getPerPage();
		List<Notice> list =  session.selectList("NoticeMapper.selectList", null, new RowBounds(offset, limit));
		
		
		pageDTO.setList(list);
		pageDTO.setCurPage(curPage);
		pageDTO.setTotalCount(totalCount());
		
		return pageDTO;
	}

	// 조회수 증가
	public int readCnt(int no) {
		return session.update("NoticeMapper.readCnt", no);
	}
	public Notice selectByNo(int no) {
		//조회수 증가 메서드 호출
		int num = readCnt(no);
		return session.selectOne("NoticeMapper.selectByNo", no);
	}

	public int noticeWrite(Notice notice) {
		return session.insert("NoticeMapper.noticeWrite", notice);
	}

	public int noticeUpdate( Notice notice) {
		return session.update("NoticeMapper.noticeUpdate", notice);
	}

	public int noticeDelete(int no) {
		return session.delete("NoticeMapper.noticeDelete", no);
	}

}
