package com.example.demo.error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RefCheckedErrorController {

	
	
	
	@ExceptionHandler(Exception.class)
	protected String handleAllException(Exception e, Model model) {
		System.out.println(e.getMessage());
		model.addAttribute("error","잘못된 요청 정보입니다. 다시 시도해주세요");
		return "error/errorPage";
	}
	
}
