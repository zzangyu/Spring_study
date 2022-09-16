package com.global.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	@Pointcut("execution(* com.global.biz..*Impl.*(..))")
	public void allPointcut(){}
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		// before와 after 둘 다 받음
		System.out.println("[BEFORE] : 비즈니스 메소드 수행 전에 처리할 내용....");
		Object returnObj = pjp.proceed();
		System.out.println("[AFTER] : 비즈니스 메소드 수행 후에 처리할 내용....");
		
		return returnObj;
	}
	
	@Around("allPointcut()")
	public Object aroundLogJoinPoint(ProceedingJoinPoint pjp) throws Throwable {
		// before와 after 둘 다 받음
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		Object obj = pjp.proceed();
		stopWatch.stop();
		
		System.out.println(method+"()메소드 수행에 걸린 시간: "+stopWatch.getTotalTimeSeconds()+"(ms)초");
		
		return obj;
	}
	
}
