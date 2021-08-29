package com.example.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.CheckList;
import com.example.entity.CheckRecommend;
import com.example.entity.Member;
import com.example.entity.Symptom;
import com.example.entity.Vitamin;
import com.example.entity.VitaminDay;
import com.example.repository.CheckListRepository;
import com.example.repository.CheckRecommendRepository;
import com.example.repository.MemberRepository;
import com.example.repository.SymptomRepository;
import com.example.repository.VitaminDayRepository;
import com.example.repository.VitaminRepository;


@RestController
public class HomeController {

	@Autowired
	CheckListRepository cRepository;
	
	@Autowired
	MemberRepository mRepository;
	
	@Autowired
	VitaminRepository vRepository;
	
	@Autowired
	CheckRecommendRepository rRepository;
	
	@Autowired
	VitaminDayRepository dRepository;
	
	@Autowired
	SymptomRepository sRepository;
	

	@ResponseBody
	@PostMapping("join")
	public String homePOST(String id, String pw, String name) {
		Member member = new Member();
		member.setId(id);
		member.setName(name);
		member.setPw(pw);
		
		System.out.println(member);
		mRepository.save(member);
		
		return "회원가입 완료";
		
	}
	
	@ResponseBody
	@PostMapping("login")
	public String MemberList(String id, String pw) {

	
		Member member = mRepository.findById(id);

		if(pw.equals(member.getPw())){
			return id;
		}
		else{
			return "로그인 실패";
		}
		
	}
	

	@ResponseBody
	@PostMapping("checkPost")
	public List<CheckRecommend> CheckPost(String checked) {
		
		String[] checkedid = checked.split(" ");

		
		List<CheckRecommend> recommendlist = new ArrayList<CheckRecommend>();
		
		for(int i=0; i<checkedid.length; i++) {
			System.out.println(checkedid[i]); // check[i] -> checklist의 선택되서 들어온 값
			List<CheckRecommend> recommend = rRepository.findByCheckedlist(Long.parseLong(checkedid[i]));
			
			System.out.println(recommend.size());
			
			recommendlist.addAll(recommend);
		}
		
		
		return recommendlist;
	}
	
	@ResponseBody
	@PostMapping("search")
	public List<Vitamin> SearchPost(String search) {
			
		List<Vitamin> searchresult = vRepository.findNameByvitaminsearchIgnoreCaseContaining(search);	
		return searchresult;
				
	}
		
		
	@ResponseBody
	@GetMapping("nutrition")
	public List<Vitamin> nutrition(int vitaminid){
		
		List<Vitamin> list = vRepository.findAllById(vitaminid);
		return list; 
	}


	@ResponseBody
	@GetMapping("vitaminlist")
	public List<String> VitaminList(){
		
		List<String> list = vRepository.findIdAndName();
		return list; 
	}
	
	@ResponseBody
	@GetMapping("symptomlist")
	public List<Symptom> SymptomList(String vitaminsearch){
		
		List<Symptom> list = sRepository.findByvitaminsearchIgnoreCaseContaining(vitaminsearch);
		return list; 
	}


	@ResponseBody
	@GetMapping("checklist")
	public List<CheckList> CheckList(){
		
		
		List<CheckList> list = cRepository.findAll();
		Collections.shuffle(list);
		
		for(CheckList vo : list) {
				vo.getCheckid();
		}

		return list;
	}
	
	@ResponseBody
	@GetMapping("vitaminday")
	public List<VitaminDay> VitaminDayList(){
		
		List<VitaminDay> list = dRepository.findAll();
		return list; 
	}
	
	

	
	
	
	
	
}
