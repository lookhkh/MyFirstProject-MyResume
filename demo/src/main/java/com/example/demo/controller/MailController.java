package com.example.demo.controller;

import java.security.InvalidParameterException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.member.domain.AboutMeBoardVO;
import com.example.demo.member.domain.MailVO;
import com.example.demo.util.MailUtils;
import com.google.gson.Gson;

@Controller
@RequestMapping("/mail")
@CrossOrigin("*")
public class MailController {
	
	@Autowired
	MailUtils mail;
	
	@GetMapping
	public String mailform() {
		return "test";
	}
	
	@PostMapping( consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> mailsender(@Valid @RequestBody MailVO check, BindingResult result){
		
		
		
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				return new ResponseEntity<String>(error.getDefaultMessage(),HttpStatus.BAD_REQUEST);

			}

		}
		mail.mailSend(check);
		
		return new ResponseEntity<String>(HttpStatus.OK);
		
		
		
	}
	
	@ResponseBody
	@GetMapping(value="/test")
	public AboutMeBoardVO test() {
		System.out.println("호출됨");
		
		AboutMeBoardVO vo = new AboutMeBoardVO();
		vo.setBno(1L);
		vo.setContent("hi");
		vo.setImgpath("/img");
		vo.setTitle("title");

		
		return vo;
	}
	
}
