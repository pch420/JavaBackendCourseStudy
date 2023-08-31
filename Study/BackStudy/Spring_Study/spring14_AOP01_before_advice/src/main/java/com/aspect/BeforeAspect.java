package com.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// target인 UserService의 sayEcho() 메서드 호출시 위빙되는 aspect 객체

@Aspect
public class BeforeAspect {

	@Pointcut("execution(public String sayEcho())") // UserService의 sayEcho 메서드
	public void xxx() { // pointcut을 위해 만든 메서드 (메서드 기능 없음)
	}

	@Before("xxx()") // pointcut에 있는 메서드(sayEcho 메서드) 호출 전에 실행
	public void method2() {
		System.out.println("BeforeAspect.method2");
	}

	// advice + pointcut 같이 표현
	@Before("execution(* callEcho(..))") // callEcho() 호출전에 실행됨
	public void method3() {
		System.out.println("BeforeAspect.method3");
	}

}
