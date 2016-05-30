package com.mvc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.perma.model.Member;
import com.perma.service.MemberService;

/*
 * ³ÉÔ±µÄÒ³Ãæ¿ØÖÆÆ÷
 */

@Controller
@RequestMapping("/member")
public class MemberController {

	@Resource
	private MemberService ms;
	private List<Member> memberlist;

	@RequestMapping("/allmember")
	public ModelAndView allMember() {
		memberlist = ms.getAll();
		if (memberlist != null) {
			return new ModelAndView("member/allmember", "memberlist",
					memberlist);
		}
		return new ModelAndView("user/hello", "errorMsg", "²éÕÒÊ§°Ü");
	}

	@RequestMapping("/addpage")
	public String addPage() {
		return "member/add";
	}

	@RequestMapping("/add")
	public ModelAndView add(Member member) {
		int result = ms.add(member);
		if (result > 0) {
			memberlist.add(member);
			return new ModelAndView("member/allmember", "memberlist",
					memberlist);
		}
		return new ModelAndView("member/add", "errorMsg", "Ìí¼ÓÊ§°Ü");
	}

	@RequestMapping("/delete")
	public ModelAndView delete(int id) {
		int result = ms.delete(id);
		if (result > 0) {
			return new ModelAndView("redirect:/member/allmember.do");
		}
		return new ModelAndView("member/allmember", "errorMsg", "É¾³ýÊ§°Ü");
	}

	@RequestMapping("/updatepage")
	public String updatePage(int id, ModelMap model) {
		Member member = null;
		Integer i = 0;
		for (Member m : memberlist) {
			if (m.getId() == id) {
				member = m;
				break;
			}
			i++;
		}
		model.put("member", member);
		model.put("num", i);
		return "member/update";
	}

	@RequestMapping("/update")
	public ModelAndView update(int num, Member member) {
		int result = ms.update(member);
		if (result > 0) {
			memberlist.set(num, member);
			return new ModelAndView("member/allmember", "memberlist",
					memberlist);
		}
		return new ModelAndView("member/update", "errorMsg", "ÐÞ¸ÄÊ§°Ü");
	}
}
