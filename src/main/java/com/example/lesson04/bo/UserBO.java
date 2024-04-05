package com.example.lesson04.bo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.User;
import com.example.lesson04.mapper.UserMapper;

@Service
public class UserBO {
	
	@Autowired
	private UserMapper userMapper;
	
	// input: 4개 파라미터
	// output: X
	public void addUser(String name, String yyyymmdd,
			String email, String introduce) {

		userMapper.insertUser(name, yyyymmdd, email, introduce);
	}

	// input: X
	// output: User or null  
	public User getLatestUser() {
		return userMapper.selectLatestUser();
	}
	
	// input: name(Stiring)
	// output: boolean 중복:true 중복아님:false
	public boolean isDuplicationByName(String name) {
		return userMapper.isDuplicationByName(name);
	}
}