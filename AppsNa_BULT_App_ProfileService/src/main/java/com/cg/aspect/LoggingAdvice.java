package com.cg.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Pointcut;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
@Aspect
public class LoggingAdvice {

	private Logger logger=LoggerFactory.getLogger(LoggingAdvice.class);
	@Pointcut(value="execution(* com.cg.controller.*.*(..) )")
	public void Pointcut() {

	}

	@Around("Pointcut()")
	public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable {
		ObjectMapper  map=new ObjectMapper();
		String methodName=joinPoint.getSignature().getName();
		String className=joinPoint.getTarget().getClass().toString();
		Object[] array=joinPoint.getArgs();
		logger.info("Method invoked "+className+" : "+methodName+" Args "+map.writeValueAsString(array));
		Object obj=joinPoint.proceed();
		logger.info("Response  "+className+" : "+methodName+" Args "+map.writeValueAsString(obj));
		return obj;
	}
}
