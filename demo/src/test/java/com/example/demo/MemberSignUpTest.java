package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.domain.MemberSignUpDTO;
import com.example.demo.member.domain.SavedMemberDTO;
import com.example.demo.member.repository.MemberRepository;

@SpringBootTest
public class MemberSignUpTest {

	@Autowired
	MemberRepository service;
	
	@Test
	public void test() {
		
		service.save(new MemberSignUpDTO("tester", "123", "123", "lookhkh@gamil.com"));
		service.save(new MemberSignUpDTO("tester1", "123", "123", "lookhkh@gamil.com"));
		service.save(new MemberSignUpDTO("tester2", "123", "123", "lookhkh@gamil.com"));

		SavedMemberDTO dto = service.getUserInfo("tester");
		SavedMemberDTO dto1 = service.getUserInfo("tester1");
		SavedMemberDTO dto2 = service.getUserInfo("tester2");

		
		System.out.println(dto.getUserName());
		System.out.println(dto.getAuth());
		System.out.println(dto.getEmail());
		System.out.println(dto.getPassWord());

		
		System.out.println(dto1.getUserName());
		System.out.println(dto1.getAuth());
		System.out.println(dto1.getEmail());
		System.out.println(dto1.getPassWord());
		
		System.out.println(dto2.getUserName());
		System.out.println(dto2.getAuth());
		System.out.println(dto2.getEmail());
		System.out.println(dto2.getPassWord());

		
		
		String test_result1 = service.checkTheId("tester");
		String test_result2 = service.checkTheId("teste22r");

		Assertions.assertThat(test_result1).isEqualTo("Y");
		
		Assertions.assertThat(test_result2).isEqualTo("N");

	}
}
