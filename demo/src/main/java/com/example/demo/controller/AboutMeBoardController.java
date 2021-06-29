package com.example.demo.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.member.domain.AboutMeBoardTempVO;
import com.example.demo.member.domain.AboutMeBoardVO;
import com.example.demo.member.repository.AboutMeBoardRepository;
import com.example.demo.util.ImgControlService;

@Controller
@RequestMapping("/about")
@CrossOrigin("*")
public class AboutMeBoardController {
	
	@Autowired
	AboutMeBoardRepository mapper;
	
	@Autowired
	private ImgControlService service;
	
	@GetMapping("/register")
	public String registerForm() {

		return "/aboutMyself/register";
	}
	
	@PostMapping("/register")
	public String postForm(@ModelAttribute AboutMeBoardTempVO vo, RedirectAttributes rttr) throws IllegalStateException, IOException {
		
		System.out.println(vo.toString());
		AboutMeBoardVO dto = service.translator(vo);
		mapper.save(dto);
		System.out.println(dto.toString());
		
		rttr.addFlashAttribute("upload", "ok");
		
		return "redirect:/about";
	}


	
	
	@GetMapping
	public String getlist(Model model){
		
		List<AboutMeBoardVO> list = mapper.getLists();
		model.addAttribute("list",list);

		return "/aboutMyself/index";
	}
	
	@ResponseBody
	@GetMapping("/images/{fileName}")
	public Resource getImages(@PathVariable String fileName) throws MalformedURLException {

		return new UrlResource("file:"+service.fullNameGetter(fileName));
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
