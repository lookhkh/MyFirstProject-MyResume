package com.example.demo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.member.domain.MemberAuthorization;
import com.example.demo.member.domain.SavedMemberDTO;


@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	MemberMapper mapper;
	
	@Autowired
	PasswordEncoder encoder;
	
	private final String prefix = "ROLE_";
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		List<GrantedAuthority> list = new ArrayList<>();
		SavedMemberDTO dto = mapper.getUserInfo(username);
		list.add(new SimpleGrantedAuthority(prefix+dto.getAuth().toString()));
		System.out.println(list.get(0).toString());
		

		UserDetails user = new User(dto.getUserName(),dto.getPassWord(), list);
		
		return user;
	}
}
