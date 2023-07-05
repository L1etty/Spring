package com.kyung2am.spring.ex.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class Ex01Controller {
	
	@RequestMapping("/lifecycle/ex01/1")
	@ResponseBody
	public String StringResponse() {
		return "<h1>예제 1번 문자열을 담기</h1>";
	}
	
	// 맵 리턴
	@RequestMapping("lifecycle/ex01/2")
		@ResponseBody
	public Map<String, Integer> mapResponse(){
		// 과일 이름 : 가격
		Map<String, Integer> fruitMap = new HashMap<>();
		
		fruitMap.put("apple", 1200);
		fruitMap.put("banana", 3000);
		fruitMap.put("orange", 1000);
		
		return fruitMap;
		
	}
	
}
