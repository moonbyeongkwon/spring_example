package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // 객체를 출력할 때 필드 값들이 보인다.
@AllArgsConstructor // 모든 파라미터가 있는 생성자
@NoArgsConstructor // 파라미터 없는 생성자
@Getter
@Builder(toBuilder = true) // setter의 대용, toBuilder=true 필드 수정 허용
@Entity // 이 객체는 entity이다. DB-JPA 통신 사이
@Table(name = "new_student")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private String name;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp // 시간값을 넣지 않아도, 현재 시간으로 자동으로 넣어줌
	@Column(name = "createdAt", updatable = false) // 업데이트시 시간 변경 막음
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
	

}
