package com.service;

import java.util.HashMap;
import java.util.List;

import com.dto.EmpDTO;

public interface EmpService {
	public List<EmpDTO> findAll();

	public int addEmp(HashMap<String, Object> map);

}
