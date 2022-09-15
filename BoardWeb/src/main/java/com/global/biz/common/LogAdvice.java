package com.global.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect // Aspect = Pointcut + Advice
public class LogAdvice {
	
	@Pointcut("execution(* com.global.biz..*Impl.*(..))")
	public void allPointcut(){}
	/*
	@Pointcut("execution(* com.global.biz..*Impl.get*(..))")
	public void getPointcut() {}
	*/
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[���� �α�] ����Ͻ� ���� ���� ���� ����");
	}
	
}
