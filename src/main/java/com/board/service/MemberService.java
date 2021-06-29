package com.board.service;

import java.util.List;

import com.board.dto.Member;

public interface MemberService {
	public List<Member> searchAllMember();
	public Member searchMember(String id);
	public void addMember(Member member);
}
