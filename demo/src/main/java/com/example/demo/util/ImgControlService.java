package com.example.demo.util;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.member.domain.AboutMeBoardTempVO;
import com.example.demo.member.domain.AboutMeBoardVO;

@Component
public class ImgControlService {

	@Value("${file.dir}")
	public String path;
	
	
	public AboutMeBoardVO translator(AboutMeBoardTempVO vo) throws IllegalStateException, IOException {
		
		String realName=null;
		
		AboutMeBoardVO dto = new AboutMeBoardVO();
		dto.setContent(vo.getContent());
		dto.setTitle(vo.getTitle());
		
		MultipartFile file = vo.getFile();
		
		if(file!=null) {
			 realName = file.getOriginalFilename();
		}
		
		String fullName = fullNameGetter(realName);
		
		dto.setImgpath(realName);
		
		System.out.println(fullName);
		
		file.transferTo(new File(fullName));
		
		return dto;
	}
	
	public String fullNameGetter(String fileName) {
	
		return path+fileName;
	}
	
}
