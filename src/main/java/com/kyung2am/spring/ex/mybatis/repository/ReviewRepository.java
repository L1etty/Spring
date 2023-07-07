package com.kyung2am.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kyung2am.spring.ex.mybatis.domain.Review;

@Repository
public interface ReviewRepository {

	// ID가 3인 review 데이
	public Review selectReview(@Param("id") int id);

}
