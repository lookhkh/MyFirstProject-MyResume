package com.example.demo.AOP;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.member.domain.MemberAuthorization;


@Aspect
@Component
public class LogAOP {
   

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void GetMapping(){ 
		
	}

	
	 @Before("GetMapping()")
	    public void before(JoinPoint joinPoint) {
		 log.info(joinPoint.getClass().getName()+"클래스가 실행됨");
		 log.info(joinPoint.getArgs().toString()+"가 인수로 들어옴");
	    }
	

	
	
}
