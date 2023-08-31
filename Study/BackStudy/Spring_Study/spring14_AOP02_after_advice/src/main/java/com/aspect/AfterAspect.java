package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// target인 UserService의 sayEcho() 메서드 호출시 위빙되는 aspect 객체

@Aspect
public class AfterAspect {

	@Pointcut("execution(public String sayEcho())") // UserService의 sayEcho 메서드
	public void xxx() { // pointcut을 위해 만든 메서드 (메서드 기능 없음)
	}

	@After("xxx()") // pointcut에 있는 메서드(sayEcho 메서드) 호출 후에 실행
	public void method2() {
		System.out.println("AfterAspect.method2");
	}

	// advice + pointcut 같이 표현
	@After("execution(* callEcho(..))") // callEcho() 호출후에 실행됨
	public void method3(JoinPoint point) {
		// 핵심기능의 어떤 메서드를 호출했는지 정보를 얻을 수 있음
		System.out.println("호출한 핵심기능 메서드명:" + point.getSignature().getName());
		System.out.println("AfterAspect.method3");
	}

}
