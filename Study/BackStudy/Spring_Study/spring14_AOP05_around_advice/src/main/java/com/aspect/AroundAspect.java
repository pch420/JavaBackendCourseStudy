package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// target인 UserService의 sayEcho() 메서드 호출시 위빙되는 aspect 객체

@Aspect
public class AroundAspect {

	@Pointcut("execution(public String sayEcho())") // UserService의 sayEcho 메서드
	public void xxx() { // pointcut을 위해 만든 메서드 (메서드 기능 없음)
	}

	// sayEcho() 호출해서 호출전, 호출후, 정상적으로 리턴, 예외발생했을 때 위빙된다.
	// AfterThrowing 속성은 sayEcho()메서드에서 예외가 발생했을 때만 예외를 지정될 변수를 지정함.
	@Around(value = "xxx()")
	public Object method2(ProceedingJoinPoint pjp) throws Throwable { // afterThrowing 역할
		System.out.println("AroundAspect.method2>>");
		System.out.println("before advice 역할");
		Object xxx = pjp.proceed(); // pjp.proceed()메서드가 sayEcho() 호출하고 리턴값을 xxx에 저장
		// 예외가 발생한다면 이 밑으론 출력안됨.

		System.out.println("after advice 역할");
		System.out.println("afterReturning advice 역할 " + xxx);
		return xxx; // sayEcho() 호출한 곳으로 리턴. main에서 받음
	}

}
