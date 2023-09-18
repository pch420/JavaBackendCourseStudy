package com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.LoginDTO;

@Controller
public class LoginController {

	@GetMapping("/loginForm")
	public String home() {
		System.out.println("LoginController.home 메서드");
		return "loginForm"; // /WEB-INF/views/loginForm.jsp 로 포워드 요청된다.
	}

	// Map 에 key value 형태로 로그인 정보 저장
	@GetMapping("/login")
	public String login(@RequestParam Map<String, String> m) {
		// 사용자 입력 데이터 얻기
		System.out.println(m);
		return "loginForm";
	}
	
	// dto에 로그인 정보 저장
	@GetMapping("/login5")
	public String login5(LoginDTO dto) {
		// 사용자 입력 데이터 얻기
		System.out.println(dto);
		return "loginForm";
	}
	
	// @RequestParam value값과 저장할 변수명이 같으면 생략가능함
	/*-
		요청 파라미터명과 저장할 변수명이 일치하면
		요청 파라미터명을 생략할 수 있다.
	*/
	@GetMapping("/login4")
	public String login4(@RequestParam String userid, 
						@RequestParam("passwd") String pw) {
		// 사용자 입력 데이터 얻기
		System.out.println(userid + " " + pw);
		return "loginForm";
	}

	// jsp의 사용자데이터 name값과 RequestParam의 값이 일치하지 않은 경우
	/*-
		@RequestParam 사용 주의할 점
		- 반드시 요청파라미터가 존재해야 한다. (필수사항)
		- 필수사항을 옵션으로 변경이 가능하다.
		- required=false 으로 지정해서 예외 대신 null이 발생하게 함
		  null 값 대신에 기본값으로 설정도 가능하다.
	*/
	@GetMapping("/login3")
	public String login3(@RequestParam(value = "userid2", 
									  required = false, 
									  defaultValue = "hello") String id, 
						@RequestParam("passwd") String pw) {
		// 사용자 입력 데이터 얻기
		System.out.println(id + " " + pw);
		return "loginForm";
	}
	
	// jsp의 사용자데이터 name값과 RequestParam의 값이 정확히 일치한 경우
	@GetMapping("/login2")
	public String login2(@RequestParam("userid") String id, 
						 @RequestParam("passwd") String pw) {
		// 사용자 입력 데이터 얻기
		System.out.println(id + " " + pw);
		return "loginForm";
	}

	// 현업에서 사용x
	@GetMapping("/login1")
	public String login1(HttpServletRequest request) {
		// 사용자 입력 데이터 얻기
		System.out.println("LoginController.get-login 메서드");
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		System.out.println(userid + " " + passwd);
		return "loginForm";
	}

	@PostMapping("/login") // 요청맵핑값이 같아도 get post로 구별되므로 에러가 안남
	public String login1_1(HttpServletRequest request) {
		// 사용자 입력 데이터 얻기
		System.out.println("LoginController.post-login 메서드");
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		System.out.println(userid + " " + passwd);
		return "loginForm";
	}

}
