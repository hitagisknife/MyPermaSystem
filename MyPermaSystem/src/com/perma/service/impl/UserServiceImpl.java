package com.perma.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.perma.dao.UserDAO;
import com.perma.model.User;
import com.perma.sevice.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDAO userDao;

	public User login(User user) {
		User u = userDao.login(user);
		return u;
	}

	public int register(User user, String password2) {
		if (user.getPassword().equals(password2))
			return userDao.add(user);
		return -1;
	}

	public int update(User user) {
		int result = userDao.update(user);
		return result;
	}

	public int delete(int id) {
		return userDao.delete(id);
	}

	public List<User> getAll() {
		return userDao.getAll();
	}
}
