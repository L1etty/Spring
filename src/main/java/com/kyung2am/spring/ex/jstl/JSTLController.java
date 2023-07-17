package com.kyung2am.spring.ex.jstl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jstl")
public class JSTLController {

	@GetMapping("/ex01")
	public String ex01() {
		return "jstl/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		List<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("수박");
		fruitList.add("바나나");
		
		model.addAttribute("fruitList", fruitList);
		
		// 사용자 정보 리스트
		// 사용자 정보 : 이름, 나이, 취미
		
		
		List<Map<String, Object>> userList = new ArrayList<>();
		
		Map<String, Object> user = new HashMap<>();
		user.put("name", "김경남");
		user.put("age", 24);
		user.put("hobby", "독서");
		userList.add(user);
		
		Map<String, Object> user2 = new HashMap<>();
		user2.put("name", "바다");
		user2.put("age", 5);
		user2.put("hobby", "사냥하기");
		userList.add(user2);
		
		model.addAttribute("userList", userList);
		
		
		return "jstl/ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		Date date = new Date();
		
		String dateString = "2023/07/14 20:53:12";
		
		model.addAttribute("dateString", dateString);
		
		model.addAttribute("now", date);
		
		return "jstl/ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04() {
		return "/jstl/ex04";
	}
	
}
