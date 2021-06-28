package com.example.demo.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CookieAOP {

	
	Logger log = LoggerFactory.getLogger(getClass());

	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)&&@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void EveryMapping(){ 
		
	}

	
	 @Before("EveryMapping()")
	    public void before(JoinPoint joinPoint) {
		 log.info("쿠키 전달 AOP 실행");
	    }
	

}
