package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.member.domain.MailVO;

@Service
public class MailUtils {
		
		
	  @Autowired private JavaMailSender mailSender;
	    private String To = "lookhkh37@gmail.com";

	    public void mailSend(MailVO vo) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        System.out.println("1");
	        message.setTo(this.To);
	        System.out.println("2");
	        message.setFrom(vo.getContactInfo());
	        System.out.println("3");

	        message.setSubject(vo.getTitle());
	        System.out.println("4");

	        message.setText("이름 : "+vo.getWho()+" "+"제목 : "+vo.getTitle()+" "+"연락처 정보 : "+vo.getContactInfo()+" "+"내용 : "+vo.getContent());
	        System.out.println("5");

	        mailSender.send(message);
	        System.out.println("6");

	    }
	}

