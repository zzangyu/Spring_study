package com.global.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	@Pointcut("execution(* com.global.biz..*Impl.*(..))")
	public void allPointcut(){}

	@After("allPointcut()")
	public void finallyLog() {
		// 에러가 나도 무조건 실행된다.
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 무조건 실행");
	}
	 
}
