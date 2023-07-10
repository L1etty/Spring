package com.kyung2am.spring.ex.mybatis;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyung2am.spring.ex.mybatis.domain.Review;
import com.kyung2am.spring.ex.mybatis.service.ReviewService;

@RequestMapping("/mybatis")
@Controller
public class ReviewController {

	// ID가 3인 review 데이터 조회 
	@Autowired
	public ReviewService reviewService;
	
	@RequestMapping("/review")
	@ResponseBody
	public Review review(@RequestParam("id") int id) {
		Review review = reviewService.getReview(id);
		return review;
	}
	
	// 새로운 리뷰를 등록하는 기능
	@RequestMapping("/ex02")
	@ResponseBody
	public String createReview(){
		// 4, 콤비네이션 피자, 김경남, 4.5, 할인도 많이 받고 잘 먹었어요.
//		int count = reviewService.addReview(4, "콤비네이션 피자", "김경남", 4.5, "할인도 많이 받고 잘 먹었어요.");
		
		// 2, 뿌링클, 김경남, 4.0, 역시 뿌링클은 진리 입니다.
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김경남");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리 입니다.");
		int count = reviewService.addReviewByObject(review);
		
		return "삽입 개수 : " + count; 
	}
	
}
