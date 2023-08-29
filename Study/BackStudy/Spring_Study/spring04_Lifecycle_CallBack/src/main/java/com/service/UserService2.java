package com.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class UserService2 implements InitializingBean, DisposableBean {

	public UserService2() {
		System.out.println("UserService 생성자");
	}

	// DisposableBean
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean.destroy()");
	}

	// InitializingBean
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("생성자 호출 후 InitializingBean.afterPropertiesSet()");
	}

}
