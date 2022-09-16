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
		// ������ ���� ������ ����ȴ�.
		System.out.println("[���� ó��] ����Ͻ� ���� ���� �� ������ ����");
	}
	 
}
