package com.service;

import java.util.HashMap;

import com.dto.NoticeDTO;
import com.dto.PageDTO;

public interface NoticeService {

	public PageDTO list(int curPage);

	public int write(NoticeDTO dto);

	public NoticeDTO retrieve(int no);

	public int update(NoticeDTO dto);

	public int delete(int no);
}
