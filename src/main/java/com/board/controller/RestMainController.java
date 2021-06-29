package com.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.dto.Member;
import com.board.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins= {"*"}, maxAge=6000)
@Api(value = "problem_corporation", description = "corporation problem controller")
public class RestMainController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/login")
	@ApiOperation("로그인")
	public Map<String, String> login(@RequestBody Map<String, String> parameter) throws IOException {
		String userId = parameter.get("userId");
		String userPassword = parameter.get("userPassword");
		
		System.out.println("UserId : " + userId);
		System.out.println("UserPassword : " + userPassword);
		
//		String encodeUserPassword = passwordEncoder.encode(userPassword);
//		
//		System.out.println("EncodeUserPassword : " + encodeUserPassword);
		
		Member member = memberService.searchMember(userId);
		boolean flag = passwordEncoder.matches(userPassword, member.getPassword());
		
		Map<String, String> res = new HashMap<String, String>();
		if(flag) {
			res.put("status", "OK");
		} else {
			res.put("status", "NO");
		}
		
//		String one = passwordEncoder.encode("dudwnd");
//		System.out.println("one : " + one);
//		String two = passwordEncoder.encode("dudwnd");
//		System.out.println("two : " + two);
//		System.out.println("flag1 : " + passwordEncoder.matches("dudwnd", one));
//		System.out.println("flag2 : " + passwordEncoder.matches("dudwnd", two));
		
//		System.out.println(memberService.searchMember("kyj"));
		
		return res;
	}
}
