package com.app.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component(value = "loggingAspect")
public class LoggingAspect {
	
	private static final Logger LOG = LogManager.getLogger(LoggingAspect.class);
	
	@Pointcut("within(com.app.controller.LoginController)")
	public void controllerLog() {
	}
	
	@Pointcut("within(com.app.service.LoginService)")
	public void serviceLog() {
	}
	
	@After(value = "controllerLog()")
	public void reachEndPointLogs(JoinPoint jp) {
		LOG.error("The Controller " + jp.getSignature().getName() + " method was called.");
	}
	
	@AfterReturning(value = "controllerLog()", returning = "returnedValue")
	public void afterReturningControllerLogs(JoinPoint jp, Object returnedValue) {
		LOG.error("The Controller " + jp.getSignature().getName() + " has returned " + returnedValue);
	}

	@After(value = "serviceLog()")
	public void reachServiceLogs(JoinPoint jp) {
		LOG.error("The Service" + jp.getSignature().getName() + " method was called.");
	}
	
	@AfterReturning(value = "serviceLog()", returning = "returnedValue")
	public void afterReturningServiceLogs(JoinPoint jp, Object returnedValue) {
		LOG.error("The Service " + jp.getSignature().getName() + " has returned " + returnedValue);
	}
	
	
}
