package com.board.dto;

import lombok.Data;

@Data
public class Member {
	private int member_no;
	private boolean isAdmin;
	private String id, password, name, nickname;
	
	public Member() {}
	
	public Member(int member_no, boolean isAdmin, String id, String password, String name, String nickname) {
		this.member_no = member_no;
		this.isAdmin = isAdmin;
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
	}
}
