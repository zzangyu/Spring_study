package com.global.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		// before�� after �� �� ����
		System.out.println("[BEFORE] : ����Ͻ� �޼ҵ� ���� ���� ó���� ����....");
		Object returnObj = pjp.proceed();
		System.out.println("[AFTER] : ����Ͻ� �޼ҵ� ���� �Ŀ� ó���� ����....");
		
		return returnObj;
	}
	
	public Object aroundLogJoinPoint(ProceedingJoinPoint pjp) throws Throwable {
		// before�� after �� �� ����
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		Object obj = pjp.proceed();
		stopWatch.stop();
		
		System.out.println(method+"()�޼ҵ� ���࿡ �ɸ� �ð�: "+stopWatch.getTotalTimeSeconds()+"(ms)��");
		
		return obj;
	}
	
}
