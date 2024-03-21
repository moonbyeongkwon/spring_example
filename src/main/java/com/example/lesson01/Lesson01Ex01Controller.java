package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01")
@Controller // Spring bean 등록
public class Lesson01Ex01Controller {

	// url: http://localhost:8080/lesson01/ex01/1
	// String을 브라우저에 출력
	@ResponseBody 
	@RequestMapping("/1")
	public String ex01_1() {
		return "<h2>문자열을 Response body에 보내는 예제</h2>";
	}
	
	// url: http://localhost:8080/lesson01/ex01/2
	// Map 출력 => JSON String 출력
	@ResponseBody
	@RequestMapping("/2")
	public Map<String,Object> ex01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("사과", 30);
		map.put("라즈베리", 222);
		map.put("버너너", 10);
		map.put("딸기", 16);
		
		
		return map;
	}
}
