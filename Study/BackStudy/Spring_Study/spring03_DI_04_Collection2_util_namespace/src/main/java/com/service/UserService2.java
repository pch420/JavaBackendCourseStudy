package com.service;

import java.util.Set;

import com.dto.Cat;

public class UserService2 {

	// 순서가 없음, 중복 불가
	Set<Cat> catSet;

	public Set<Cat> getCatSet() {
		return catSet;
	}

	public void setCatSet(Set<Cat> catSet) {
		this.catSet = catSet;
	}

}
