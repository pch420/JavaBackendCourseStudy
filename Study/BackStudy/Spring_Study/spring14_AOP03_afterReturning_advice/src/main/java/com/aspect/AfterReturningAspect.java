package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// target인 UserService의 sayEcho() 메서드 호출시 위빙되는 aspect 객체

@Aspect
public class AfterReturningAspect {

	@Pointcut("execution(public String sayEcho())") // UserService의 sayEcho 메서드
	public void xxx() { // pointcut을 위해 만든 메서드 (메서드 기능 없음)
	}

	// sayEcho() 호출해서 정삭적으로 리턴값을 리턴했을 때
	@AfterReturning(pointcut = "xxx()", returning = "xxx") // returning 속성에 sayEcho()메서드가 리턴하는 값이 저장될 변수를 지정함.
	public void method2(Object xxx) { // xxx에는 sayEcho()메서드가 리턴하는 값이 저장됨.
		System.out.println("AfterReturningAspect.method2>>" + xxx);
	}

	// advice + pointcut 같이 표현
	@AfterReturning(pointcut = "execution(* callEcho(..))", returning = "yyy") // callEcho() 호출후에 실행됨
	public void method3(JoinPoint point, Object yyy) {
		// 핵심기능의 어떤 메서드를 호출했는지 정보를 얻을 수 있음
		System.out.println("호출한 핵심기능 메서드명:" + point.getSignature().getName());
		System.out.println("AfterReturningAspect.method3>>" + yyy);
	}

}
