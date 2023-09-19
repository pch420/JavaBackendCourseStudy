package com.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("PageDTO")
public class PageDTO {

	List<NoticeDTO> list; // 보여줄 레코드 목록

	int perPage = 3; // 페이지당 보여줄 행 갯수

	int totalCount; // 전체 레코드 갯수

	int curPage; // 현재 페이지 번호

	public PageDTO() {
		// TODO Auto-generated constructor stub
	}

	public PageDTO(List<NoticeDTO> list, int perPage, int totalCount, int curPage) {
		this.list = list;
		this.perPage = perPage;
		this.totalCount = totalCount;
		this.curPage = curPage;
	}

	public List<NoticeDTO> getList() {
		return list;
	}

	public void setList(List<NoticeDTO> list) {
		this.list = list;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	@Override
	public String toString() {
		return "PageDTO [list=" + list + ", perPage=" + perPage + ", totalCount=" + totalCount + ", curPage=" + curPage
				+ "]";
	}

}
