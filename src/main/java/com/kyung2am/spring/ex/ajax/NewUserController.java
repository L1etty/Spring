package com.kyung2am.spring.ex.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyung2am.spring.ex.ajax.service.NewUserService;
import com.kyung2am.spring.ex.jsp.domain.User;

@Controller
@RequestMapping("/ajax/user")
public class NewUserController {
	
	@Autowired
	private NewUserService newUserService;
	
	@GetMapping("/list")
	public String userList(Model model) {
		
		List<User> userList = newUserService.getUserList();
		
		model.addAttribute("userList", userList);
		
		return "/ajax/user/list";
	}
	
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String> createUser(
			@RequestParam("name") String name
			,@RequestParam("birthday") String birthday
			,@RequestParam("email") String email
			,@RequestParam("introduce") String introduce
			){
		int count = newUserService.addUser(name, birthday, email, introduce);
		
		// 성공 실패 여부
		// 성공 : {"result" : "success"}
		// 실패 : {"result" : "fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	@GetMapping("/input")
	public String userInput() {
		return "/ajax/user/input";
	}
	
	// email을 전달 받고, 이미 가입된 이메일인지 알려주는 API
	@GetMapping("/email_confirm")
	@ResponseBody
	public Map<String, Boolean> isDuplicateEmail(@RequestParam("email") String email){
		
		//중복됨 : {"isDuplicate":true}
		//중복안됨 : {"isDuplicate":false}
		Map<String, Boolean> resultMap = new HashMap<>();
			
		if(newUserService.isDuplicateEmail(email)) {
			//중복
			resultMap.put("isDuplicate", true);
		}else {
			//노중복
			resultMap.put("isDuplicate", false);
		}
		
		return resultMap;
		
	}
	
}
