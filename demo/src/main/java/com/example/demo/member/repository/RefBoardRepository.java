package com.example.demo.member.repository;

import java.util.List;

import com.example.demo.member.domain.RefBoardDTO;
import com.example.demo.util.PagingCriteria;

public interface RefBoardRepository {

	int insert(RefBoardDTO dto);
	List<RefBoardDTO> getLists();
	RefBoardDTO getAList(Long bno);
	void edit(RefBoardDTO dto);
	int remove(Long bno);
	List<RefBoardDTO> getListsWithPage(PagingCriteria cri);
	int getTotal(PagingCriteria cri);
}
