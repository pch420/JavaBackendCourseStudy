package com.exam.service;

import com.exam.dto.Notice;
import com.exam.dto.PageDTO;

public interface NoticeService {

	public abstract PageDTO selectList(int curPage);

	public abstract Notice selectByNo(int no);

	public abstract int noticeWrite(Notice notice);

	public abstract int noticeUpdate(Notice notice);

	public abstract int noticeDelete(int no);
}
