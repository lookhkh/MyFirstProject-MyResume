package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
	
	@Autowired
	CustomUserDetailService service;
	
	@GetMapping("/")
	public String index(HttpSession session) {
		
		SecurityContext context= SecurityContextHolder.getContext();
	
		return "/index";
	}
	
	
	@GetMapping("/signup")
	public String signupForm() {

		return "member/form";

	}

	
	  @PostMapping("/signup") 
	  public String SignUp(@ModelAttribute MemberSignUpDTO tempmemberDto, HttpServletRequest req) {
	  
		
	  SavedMemberDTO memberDto = new SavedMemberDTO(tempmemberDto.getUserName(),passwordEncoder.encode(tempmemberDto.getPassWord()), tempmemberDto.getEmail(), MemberAuthorization.MEMBER); 
	  
	  HttpSession session = req.getSession();
	  session.setAttribute("loginInfo", memberDto.getUserName());
	  SimpleGrantedAuthority auth = new SimpleGrantedAuthority(memberDto.getAuth().toString());
	  List<GrantedAuthority> list = new ArrayList<>();
	  UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(memberDto.getUserName(), memberDto.getPassWord(), list);
	  SecurityContext ctx = SecurityContextHolder.getContext();
	  ctx.setAuthentication(token);
	  
	  
	  
	  mapper.save(memberDto); 
	  	  
	  
	  
	  
	  return "redirect:/";
	  
	  }
	 



	@GetMapping("/signup/checkId")
	@ResponseBody
	public String checkTheId(@RequestParam("userName") String validedId) {
		SavedMemberDTO checkResult = mapper.checkTheId(validedId);

		System.out.println(checkResult);

		if (checkResult == null) {
			return "N";
		} else {
			return "Y";
		}
	}
	


	
	@GetMapping("/loginReq")
	public String loginPageForm(HttpServletRequest request) {
		String referrer = request.getHeader("Referer");
	    request.getSession().setAttribute("prevPage", referrer);
	    System.out.println("로그인 컨트롤러 실행");
	    return "redirect:/login";
	
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
