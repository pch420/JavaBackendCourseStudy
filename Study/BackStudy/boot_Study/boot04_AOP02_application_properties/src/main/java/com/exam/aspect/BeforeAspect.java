package com.exam.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeAspect {
	@Pointcut("execution(public String sayEcho())")
	public void xxx() {
	}

	@Before("xxx()") // sayEcho() 호출전에 실행됨
	public void method2() {
		System.out.println("BeforeAspect.method2");
	}
}
