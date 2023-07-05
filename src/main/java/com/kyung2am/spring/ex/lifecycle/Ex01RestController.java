package com.kyung2am.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("/lifecycle/ex01")
public class Ex01RestController {
	
	@RequestMapping("/3")
	public Person objectResponse() {
		Person person = new Person("김경남", 25);
		return person;
	}
	
	// status 코드를 포함한 response
	// 200 OK
	// 404 400 500
	@RequestMapping("/4")
	public ResponseEntity<Person> entityResponse(){
		Person person = new Person("김경남", 25);
		
		ResponseEntity<Person> entity = new ResponseEntity<>(person, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
		
	}
	
	
}
