package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.MemberDAO;
import com.board.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public List<Member> searchAllMember() {
		List<Member> allMember = memberDao.searchAllMember();
		return allMember;
	}

	@Override
	public Member searchMember(String id) {
		Member member = memberDao.searchMember(id);
		return member;
	}
	
	@Override
	public void addMember(Member member) {
		memberDao.addMember(member);
	}
}
