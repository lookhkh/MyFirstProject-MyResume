package com.example.demo.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionCheckInterseptor implements  HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	HttpSession session = request.getSession(true);
	session.setMaxInactiveInterval(60*30);
	
	SecurityContext ctx = SecurityContextHolder.getContext();
	if(ctx.getAuthentication().getName().equals("anonymousUser")) {
		session.setAttribute("loginInfo", null);
	}
	else {
		session.setAttribute("loginInfo", ctx.getAuthentication().getName());

	}

	return HandlerInterceptor.super.preHandle(request, response, handler);
}
}
