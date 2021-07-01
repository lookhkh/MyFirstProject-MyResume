package com.example.demo.mapper;

import java.util.List;

import org.springframework.context.annotation.Primary;

import com.example.demo.member.domain.RefBoardDTO;
import com.example.demo.member.domain.RefBoardReply;
import com.example.demo.member.repository.RefBoardRepository;
import com.example.demo.util.PagingCriteria;

@Primary
public interface RefBoardMapper extends RefBoardRepository {
	

	public int insert(RefBoardDTO dto);

	public List<RefBoardDTO> getLists(); 

	public RefBoardDTO getAList(Long bno);
	
	public void edit(RefBoardDTO dto);

	public int remove(Long bno); 

	public List<RefBoardDTO> getListsWithPage(PagingCriteria cri);
	
	
	public int getTotal(PagingCriteria cri);
	
	public int insertReply(RefBoardReply vo);

	public List<RefBoardReply> getReply(Long bno);
	
	public RefBoardReply getaReply(Long rno);

	public int insertReplyWithRoot(RefBoardReply vo);


}
