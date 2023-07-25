package com.kyung2am.spring.ex.jpa.domain;

import java.util.Date;

import lombok.Getter;

@Getter
public class Student {

	// id, 이름, 전화번호, 이메일, 장래희망
	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String dreamJob;
	private Date createdAt;
	private Date updatedAt;
	
}
