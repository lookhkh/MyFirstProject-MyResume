package com.example.demo.kakao;

import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/auth")
public class KakaoController {

	@Autowired
	KakaoAPI kakao;
	
	@GetMapping
	public String test(String code, HttpServletRequest req) throws MalformedURLException {

		System.out.println(code);
		AccessToken token = kakao.getToken(code);
		
		String name = kakao.GettingUserName(token);
		
		
		HttpSession session = req.getSession(true);
		session.setAttribute("loginInfo", name);

		
		return "redirect:/";
	}
	
	
	@GetMapping("/auth")
	public String test1(@ModelAttribute AccessToken token) {


		
		return "test";
	}
	
	
	
}
