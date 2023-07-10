package com.kyung2am.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kyung2am.spring.ex.mybatis.domain.Review;

@Repository
public interface ReviewRepository {

	// ID가 3인 review 데이
	public Review selectReview(@Param("id") int id);
	
	// 데이터를 전달 받고 insert
	public int insertReview(
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			, @Param("review") String review
			);
	public int insertReviewByObject(Review review);

}
