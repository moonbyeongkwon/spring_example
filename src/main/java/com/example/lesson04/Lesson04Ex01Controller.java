package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01")
@Controller // jsp 화면의 경우 @ResponseBody 사용 안함
public class Lesson04Ex01Controller {

	@Autowired
	private UserBO userBO;

	// 회원가입 화면
	// http://localhost/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view", method = RequestMethod.GET)
	public String addUserView() {
		return "lesson04/addUser"; // jsp 경로
	}

	// http://localhost/lesson04/ex01/add-user
	@PostMapping("/add-user")
	public String addUser(@RequestParam("name") String name, @RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required = false) String introduce) {

		// DB Insert
		userBO.addUser(name, yyyymmdd, email, introduce);

		return "lesson04/afterAddUser";
	}

	// 최근에 가입된 한명의 유저 보는 화면
	// http://localhost/lesson04/ex01/latest-user-view
	@GetMapping("/latest-user-view")

	public String latestUserView(Model model) { // Model: view 화면에 데이터를 넘겨주는 객체
		// DB select
		User user = userBO.getLatestUser();

		// Model 주머니에 담는다. => jsp에서 꺼내서 쓴다.
		model.addAttribute("result", user);
		model.addAttribute("title", "최근 가입된 유저 정보");

		return "lesson04/latestUser"; // 결과화면 jsp
	}
}
