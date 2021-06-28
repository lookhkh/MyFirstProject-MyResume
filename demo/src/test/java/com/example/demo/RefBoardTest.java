package com.example.demo;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.domain.RefBoardDTO;
import com.example.demo.member.repository.RefBoardRepository;
import com.example.demo.util.PagingCriteria;

@SpringBootTest
public class RefBoardTest {

	@Autowired
	DataSource data;
	
	@Autowired
	RefBoardRepository mapper;
	

	
	@Autowired
	SqlSessionFactory sql;
	
	
	@Test
	public void mapperTest() {
		Assertions.assertNotNull(mapper);
	}
	
	@Test
	public void mapperInsert() {

		RefBoardDTO dto = new RefBoardDTO();
		dto.setUserName("tester123");
		dto.setRelationship("친구");
		dto.setContent("좋은친구이다");
		dto.setTitle("현일이는");
		
		mapper.insert(dto);
		
		
	}
	
	@Test
	public void mapperGetTest() {

	List<RefBoardDTO> lists = mapper.getLists();
	
	for(int i=0; i<lists.size(); i++) {
		System.out.println(lists.get(i).getTitle());
	}
	
	Assertions.assertNotNull(lists);	
		
	}
	
	@Test
	public void mapperGetAListTest() {

	RefBoardDTO list = mapper.getAList(5L);
	
	System.out.println(list.toString());
	
	Assertions.assertNotNull(list);	
		
	}
	
	@Test
	public void mapperEditMethodTest() {

	RefBoardDTO list = mapper.getAList(5L);
	
	System.out.println(list.toString());
	
	list.setTitle("에디트 테스트");
	list.setContent("에디트 테스트다");
	list.setRelationship("테스트");
	
	mapper.edit(list);
	
	System.out.println(list.toString());

	Assertions.assertEquals(list.getTitle(),"에디트 테스트");	
		
	}
	
	@Test
	public void mapperRemoveTest() {
		mapper.remove(6L);
		RefBoardDTO list = mapper.getAList(6L);
		
		Assertions.assertNull(list);


	}
	
	@Test
	public void mapperPagingTest() {
		List<RefBoardDTO> list = mapper.getListsWithPage(new PagingCriteria());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("리스트 "+i+" "+list.get(i).toString());
		}
		
		System.out.println(mapper.getTotal());
		
		Assertions.assertNotNull(list);

	}
	
	
}
