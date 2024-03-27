package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {
	public Review selectReview(int id);
	
	public int insertReview(Review review);
	
	// @Param => 하나의 Map이 됨
	public int insertReviewAsField(
			@Param("storeId") int storeId11,
			@Param("menu") String menu11,
			@Param("userName") String userName11,
			@Param("point") Double point11,
			@Param("review") String review11);
	
	public int updateReviewById(
			@Param("id") int id,
			@Param("review") String review);
	
	public void deleteReviewById(int id);
}

