package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.member.domain.MemberAuthorization;
import com.example.demo.member.domain.MemberSignUpDTO;
import com.example.demo.member.domain.SavedMemberDTO;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.security.CustomUserDetailService;

@Controller
@CrossOrigin("*")
public class MemberManageController {

	@Autowired
	MemberRepository mapper;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@GetMapping("/")
	public String index(HttpSession session) {
		
		SecurityContext context= SecurityContextHolder.getContext();

		System.out.println(context.getAuthentication().getName());
		return "/index";
	}
	
	
	@GetMapping("/signup")
	public String signupForm() {

		return "member/form";

	}

	
	  @PostMapping("/signup") 
	  public String SignUp(@ModelAttribute MemberSignUpDTO tempmemberDto, HttpServletRequest req) {
	  
		  

	  SavedMemberDTO memberDto = new SavedMemberDTO(tempmemberDto.getUserName(),passwordEncoder.encode(tempmemberDto.getPassWord()), tempmemberDto.getEmail(), MemberAuthorization.MEMBER); 
	  
	  mapper.save(memberDto); 
	  	  
	  
	  //쿠키 전달 메소드 제작 필요
	  
	  return "redirect:/login";
	  
	  }
	 



	@GetMapping("/signup/checkId")
	@ResponseBody
	public String checkTheId(@RequestParam("userName") String validedId) {
		SavedMemberDTO checkResult = mapper.checkTheId(validedId);

		System.out.println(checkResult);

		if (checkResult == null) {
			System.out.println("Y를 던진다");
			return "N";
		} else {
			System.out.println("N을 던진다");
			return "Y";
		}
	}
	


	
	@GetMapping
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPageForm(HttpServletRequest request) {
		String referrer = request.getHeader("Referer");
	    request.getSession().setAttribute("prevPage", referrer);
	    return "login";
	
	}
	

	
	@GetMapping("/edit")
	public String editUserInfoForm(HttpSession session, Model model) {
		SavedMemberDTO temp = (SavedMemberDTO)session.getAttribute("userInfo");

		model.addAttribute("userInfo",temp);

		return "member/edit";
		
	}
	
	@PostMapping("/edit")
	public String editUserInfo(MemberSignUpDTO dto) {
		
		mapper.editUserInfo(dto);
		
		return "/index";
	}

}
