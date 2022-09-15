package com.global.biz.common;

public class Log4jAdvice {
	
	public void printLogging() { // 일반 java: log, Spring: log4j
		System.out.println("[공통 로그-Log4j] 비즈니스 로직 수행 전에 동작");
	}
	
}
