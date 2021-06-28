package com.example.demo;

import java.io.Console;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.domain.AboutMeBoardVO;
import com.example.demo.member.repository.AboutMeBoardRepository;

@SpringBootTest
public class AboutMeMapperTest {

	@Autowired
	AboutMeBoardRepository mapper;
	
	@Test
	public void test() {
		System.out.println(mapper);
		Assertions.assertNotNull(mapper);
		
	}
		
	@Test
	public void saveTest() {
		
		AboutMeBoardVO vo = new AboutMeBoardVO();
		vo.setContent("test for content");
		vo.setTitle("test for title");
		vo.setImgpath("img");
		int result = mapper.save(vo);
		
		Assertions.assertEquals(result, 1);
	}
	
	@Test
	public void getList() {
		List<AboutMeBoardVO> list = mapper.getLists();
		list.forEach(a->System.out.println(a.getTitle()));
	}
	
	@Test
	public void getadetail() {
		AboutMeBoardVO vo = mapper.getDetail(4L);
		System.out.println("vo" + vo.getTitle());
	}
	
	
}
