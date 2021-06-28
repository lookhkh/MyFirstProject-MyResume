package com.example.demo.mapper;

import java.util.List;

import org.springframework.context.annotation.Primary;

import com.example.demo.member.domain.AboutMeBoardVO;
import com.example.demo.member.repository.AboutMeBoardRepository;
@Primary
public interface AboutMeBoardMapper extends AboutMeBoardRepository {

	public int save(AboutMeBoardVO vo);
	public List<AboutMeBoardVO> getLists();
	public AboutMeBoardVO getDetail(Long bno);
	
}
