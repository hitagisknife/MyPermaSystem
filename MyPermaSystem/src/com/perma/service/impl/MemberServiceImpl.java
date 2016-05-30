package com.perma.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.perma.dao.MemberDAO;
import com.perma.model.Member;
import com.perma.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource
	private MemberDAO memberDao;

	public int add(Member member) {
		return memberDao.add(member);
	}

	public int update(Member member) {
		return memberDao.update(member);
	}

	public int delete(int id) {
		return memberDao.delete(id);
	}

	public List<Member> getAll() {
		return memberDao.getAll();
	}
}
