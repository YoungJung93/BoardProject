package com.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/")
	public String main() {
		System.out.println("tomain");
		return "login";
	}
	@RequestMapping(value="/tomain.do")
	public String tomain(HttpServletRequest request) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println(id);
		System.out.println(password);
		String encodePassword = passwordEncoder.encode(password);
		System.out.println(encodePassword);
		return "main";
	}
}
