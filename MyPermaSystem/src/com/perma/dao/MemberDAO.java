package com.perma.dao;

import java.util.List;

import com.perma.model.Member;

public interface MemberDAO {

	public int add(Member member);

	public int delete(int id);

	public int update(Member member);

	public Member getById(int id);

	public List<Member> getAll();
}
