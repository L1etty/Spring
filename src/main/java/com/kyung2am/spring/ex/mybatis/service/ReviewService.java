package com.kyung2am.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung2am.spring.ex.mybatis.domain.Review;
import com.kyung2am.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	// id가 3인 리뷰 데이터 얻기
	public Review getReview(int id){
		Review review = reviewRepository.selectReview(id);
		return review;
	}
	
	// storeId, menu, userName, point, review 전달 받고 저장하는 기능.
	public int addReview(int storeId, String menu, String userName, double point, String review) {
		int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
		return count;
	}
	
	public int addReviewByObject(Review review) {
		int count = reviewRepository.insertReviewByObject(review);
		return count;
	}
	
}
