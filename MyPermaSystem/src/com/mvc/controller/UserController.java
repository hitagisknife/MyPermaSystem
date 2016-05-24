package com.mvc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.perma.model.User;
import com.perma.sevice.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private List<User> userlist;

	@Resource
	private UserService userService;

	@RequestMapping("loginpage")
	public String loginPage() {
		return "user/login";
	}

	@RequestMapping("login")
	public ModelAndView login(User user) {
		User userResult = userService.login(user);
		if (userResult != null) {
			return new ModelAndView("user/hello", "currentUser", userResult);
		}
		return new ModelAndView("user/login", "errorMsg", "ÓÃ»§Ãû»òÃÜÂë´íÎó");
	}

	@RequestMapping("registerpage")
	public String registerPage() {
		return "user/register";
	}

	@RequestMapping("register")
	public ModelAndView registerPage(
			@RequestParam(value = "password2") String password2, User user) {
		int result = userService.register(user, password2);
		if (result > 0) {
			return new ModelAndView("user/hello", "currentUser", user);
		} else if (result == -1) {
			return new ModelAndView("user/register", "errorMsg", "ÖØ¸´ÊäÈëµÄÃÜÂë²»Æ¥Åä");
		}
		return new ModelAndView("user/register", "errorMsg", "×¢²áÊ§°Ü");
	}

	@RequestMapping("alluser")
	public ModelAndView allUser() {
		userlist = userService.getAll();
		if (userlist != null) {
			return new ModelAndView("user/alluser", "userlist", userlist);
		}
		return new ModelAndView("user/hello", "errorMsg", "²éÕÒÊ§°Ü");
	}

	@RequestMapping("updatepage")
	public String updatePage(@RequestParam(value = "id") String id,
			ModelMap model) {
		User user = null;
		Integer i = 0;
		for (User u : userlist) {
			if (u.getId() == Integer.parseInt(id)) {
				user = u;
				break;
			}
			i++;
		}
		model.put("user", user);
		model.put("num", i);
		return "user/update";
	}

	@RequestMapping("update")
	public ModelAndView update(@RequestParam(value = "num") Integer i,
			User user) {
		int result = userService.update(user);
		if (result > 0) {
			userlist.set(i, user);
			return new ModelAndView("user/alluser", "userlist", userlist);
		}
		return new ModelAndView("user/update", "errorMsg", "ÐÞ¸ÄÊ§°Ü");
	}

	@RequestMapping("delete")
	public ModelAndView delete(@RequestParam(value = "id") int id) {
		int result = userService.delete(id);
		if (result > 0) {
			return new ModelAndView("redirect:/user/alluser.do");
		}
		return new ModelAndView("user/alluser", "errorMsg", "É¾³ýÊ§°Ü");
	}
}
