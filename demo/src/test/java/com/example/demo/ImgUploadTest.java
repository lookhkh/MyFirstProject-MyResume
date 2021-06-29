package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.util.ImgControlService;

@SpringBootTest
public class ImgUploadTest {
	
	@Autowired
	private ImgControlService service;
	
	@Test
	public void test() {
		System.out.println(service.fullNameGetter("hy.img"));
	}
	
}
