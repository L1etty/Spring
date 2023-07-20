package com.kyung2am.spring.ex.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyung2am.spring.ex.ajax.repository.NewUserRepository;
import com.kyung2am.spring.ex.jsp.domain.User;

@Service
public class NewUserService {
	
	@Autowired
	private NewUserRepository newUserRepository;

	public List<User> getUserList() {
		List<User> userList = newUserRepository.selectUserList();
		return userList;
	}
	
	public int addUser(
			String name
			,String birthday
			,String email
			,String introduce
			) {
		int count = newUserRepository.insertUser(name, birthday, email, introduce);
		return count;
	}
	
	//전달된 email이 이미 있는지 확인하는 메소드
	public boolean isDuplicateEmail(String email) {
		
		int count = newUserRepository.selectCountEmail(email);
		
		if(count == 0) {
			return false;
			//중복X
		}
		
		return true;
		//중복O
	}
}
