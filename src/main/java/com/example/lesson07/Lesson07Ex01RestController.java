package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RestController
@RequestMapping("/lesson07")
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// C:create
	@GetMapping("/ex01/create")
	public StudentEntity create() {
		String name = "문병권";
		String phoneNumber = "010-4162-8726";
		String email = "chamak990402@naver.com";
		String dreamJob = "개발자";
		
		// save된 객체를 리턴하므라 id값이 채워져 있다.
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
}
