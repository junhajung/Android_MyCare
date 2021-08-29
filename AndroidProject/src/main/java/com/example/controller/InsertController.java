package com.example.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Vitamin;
import com.example.repository.VitaminRepository;

@Controller
public class InsertController {
	
	@Autowired
	VitaminRepository vRepository;

	
	
	@RequestMapping(value = "/insert")
	public String insertGET(Model model) {
		
		List<Vitamin> VitaminList = vRepository.findAll();
		model.addAttribute("vitaminList", VitaminList);
		
		
		
		return "insert"; //jsp만들기
	}
	

	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertPOST(
			@RequestParam("img1") MultipartFile file,
			@ModelAttribute Vitamin vo) throws IOException {
		
		// 이미지
		if(file.getBytes().length > 0) { //파일이 첨부되었다면
			vo.setImg(file.getBytes());
		}	 

		vRepository.save(vo);

		
		//DB처리
		return "redirect:/insert"; 
	}
	
	
	//// 시험단계 -> 이미지 웹에 뿌리고 안드로이드에서 받기 (미완성) /////
	
	@RequestMapping(value = "/vitamin", method = RequestMethod.GET)
	public String VitaminsList(Model model){
		
		List<Vitamin> list = vRepository.findAll();
		for(Vitamin vo : list) {
			
			if(vo.getImg() != null) {
				String tmp1 = Base64.getEncoder().encodeToString(vo.getImg());
				vo.setBase64(tmp1);
				vo.setImg(null);
			}
		}
		
		model.addAttribute("list", list);
		
		return "vitamin"; 
	}


}
