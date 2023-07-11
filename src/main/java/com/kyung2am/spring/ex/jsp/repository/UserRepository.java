package com.kyung2am.spring.ex.jsp.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kyung2am.spring.ex.jsp.domain.User;

@Repository
public interface UserRepository {

	// 사용자 정보를 전달받고 insert
	public int insertUser(
			@Param("name") String name
			, @Param("birthday") String birthday
			, @Param("email") String email
			, @Param("introduce") String introduce
			);
	
	// 가장 최근 사용자 정보 조회
	public User selectLastUser();
	
}