package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;

	// input: int id
	// output: Review
	public Review getReview(int id) {
		return reviewMapper.selectReview(id);
	}
	
	// input: Review
	// output: int(성공한 행의 개수)
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	// addReviewAsField(4, "콤비네이션R", "바다", 5.0, "역시 맛있다!")
	public int addReviewAsField(int storeId0, String menu0, String userName0, Double point0, String review0) {
		return reviewMapper.insertReviewAsField(storeId0, menu0, userName0, point0, review0);
	}
	
	//input: id, review
	//output: int
	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
}
