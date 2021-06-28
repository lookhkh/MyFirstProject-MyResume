package com.example.demo.member.repository;

import java.util.List;

import com.example.demo.member.domain.AboutMeBoardVO;

public interface AboutMeBoardRepository {
	
	int save(AboutMeBoardVO vo);
	List<AboutMeBoardVO> getLists();
	AboutMeBoardVO getDetail(Long bno);
}	
