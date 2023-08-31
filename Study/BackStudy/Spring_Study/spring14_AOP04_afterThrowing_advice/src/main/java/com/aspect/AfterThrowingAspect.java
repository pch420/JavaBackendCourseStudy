package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// target인 UserService의 sayEcho() 메서드 호출시 위빙되는 aspect 객체

@Aspect
public class AfterThrowingAspect {

	@Pointcut("execution(public String sayEcho())") // UserService의 sayEcho 메서드
	public void xxx() { // pointcut을 위해 만든 메서드 (메서드 기능 없음)
	}

	// sayEcho() 호출해서 예외가 발생했을 때 위빙된다.
	// AfterThrowing 속성은 sayEcho()메서드에서 예외가 발생했을 때만 예외를 지정될 변수를 지정함.
	// catch(xxxException e)의 e느낌?
	@AfterThrowing(pointcut = "xxx()", throwing = "e")
	public void method2(Exception e) {
		System.out.println("AfterThrowingAspect.method2>>" + e.getMessage());
	}

}
