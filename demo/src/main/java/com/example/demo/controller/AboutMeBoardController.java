package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.member.domain.AboutMeBoardVO;
import com.example.demo.member.repository.AboutMeBoardRepository;

@Controller
@RequestMapping("/about")
@CrossOrigin("*")
public class AboutMeBoardController {
	
	@Autowired
	AboutMeBoardRepository mapper;
	
	@PostMapping
	public String post(@RequestBody AboutMeBoardVO vo) {
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getImgpath());
		
		return "redirect:/aboutMyself/index";

	}
	
	
	@GetMapping
	public String getlist(Model model){
		System.out.println(" get 매핑 호출됨");
		
		List<AboutMeBoardVO> list = mapper.getLists();
		model.addAttribute("list",list);

		return "/aboutMyself/index";
	}
	
	
	@GetMapping("/detail")
	public String getdetail(@RequestParam("bno")Long bno, Model model){
		System.out.println(" 디테일 매핑 호출됨");
		
		AboutMeBoardVO vo = mapper.getDetail(bno);
		model.addAttribute("list",vo);
		
		System.out.println(vo.getImgpath());
		
		return "/aboutMyself/detail";

	}
	
	@ResponseBody
	@GetMapping("/{id}")
	public AboutMeBoardVO getDetailById(@PathVariable Long id) {
		AboutMeBoardVO vo = mapper.getDetail(id);
		
		return vo;

		
	}
	
	@ResponseBody
	@GetMapping("/list")
	public List<AboutMeBoardVO> getListAll(){
		return mapper.getLists();
	}
}
