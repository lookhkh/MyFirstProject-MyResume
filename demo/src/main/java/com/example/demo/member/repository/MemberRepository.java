package com.example.demo.member.repository;

import com.example.demo.member.domain.MemberSignUpDTO;
import com.example.demo.member.domain.SavedMemberDTO;

public interface MemberRepository {


	int save(SavedMemberDTO dto);
	SavedMemberDTO checkTheId(String userName);
	SavedMemberDTO getUserInfo(String UserName);
	void editUserInfo(MemberSignUpDTO dto);
	
}
