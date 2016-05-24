package com.perma.sevice;

import java.util.List;

import com.perma.model.Member;

public interface MemberService {

	public int add(Member member);

	public int update(Member member);

	public int delete(int id);

	public List<Member> getAll();
}
