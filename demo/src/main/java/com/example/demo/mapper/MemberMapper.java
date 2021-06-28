package com.example.demo.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Primary;

import com.example.demo.member.domain.MemberSignUpDTO;
import com.example.demo.member.domain.SavedMemberDTO;
import com.example.demo.member.repository.MemberRepository;

@Primary
public interface MemberMapper extends MemberRepository {


	
	int save(MemberSignUpDTO dto);
	
	SavedMemberDTO checkTheId(String userName);
	
	SavedMemberDTO getUserInfo(String UserName);
	
	void editUserInfo(MemberSignUpDTO dto);

}
