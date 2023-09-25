package com.exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.exam.interceptor.MyHandlerInterceptor;

@Configuration // servlet-context.xml 역할
public class WebConfig implements WebMvcConfigurer {

	/*-
		<mvc:interceptors>
			<mvc:interceptor>
				<mvc:mapping path="/loginCheck/*"/>
				<ref bean="xxx"/>
			</mvc:interceptor>
		</mvc:interceptors>
	*/
	@Autowired
	MyHandlerInterceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// /login 또는 /mypage로 요청하면 MyHandlerInterceptor로 가게함
		registry.addInterceptor(interceptor).addPathPatterns("/login", "/mypage");

	}

	/*
	 * <mvc:view-controller path="/xxx" view-name="main"/>
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// /mypage로 요청하면 main.jsp로 가게함
		registry.addViewController("/mypage").setViewName("main");
	}

}
