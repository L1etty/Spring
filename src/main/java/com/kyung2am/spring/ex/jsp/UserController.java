package com.kyung2am.spring.ex.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyung2am.spring.ex.jsp.service.UserService;

@Controller
@RequestMapping("/jsp/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	// 이름, 생년월일, 이메일, 자기소개, 전달 받고, 데이터 저장
//	@RequestMapping(path="/jsp/user/add", method = RequestMethod.POST)
	@PostMapping("/add")
	@ResponseBody
	public String createUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce
			){
		
		int count = userService.addUser(name, birthday, email, introduce);
		
		return "성공 갯수 : " + count;
	}
	
	// userInput 페이즈를 보여주기
	@GetMapping("/input")
	public String userInput(){
		return "/jsp/userInput";
	}
	
}
