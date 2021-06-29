package com.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.dto.Member;

@Mapper
public interface MemberDAO {
	public List<Member> searchAllMember();
	public Member searchMember(String id);
	public void addMember(Member member);
}
