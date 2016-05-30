package com.perma.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.memcached.CachedFactory;
import com.perma.dao.UserDAO;
import com.perma.model.User;
import com.perma.service.UserService;

import net.spy.memcached.MemcachedClient;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDAO userDao;

	public User login(User user) {
		MemcachedClient mc = CachedFactory.getCached();
		User u = (User) mc.get(user.getClass().getName() + user.getName());
		if (u == null) {
			synchronized (this) {
				if (u == null) {
					u = userDao.login(user);
					if (u == null) {
						return null;
					}
					mc.add(u.getClass().getName() + u.getName(), 10000, u);
					System.out.println((User) mc
							.get(u.getClass().getName() + u.getName()));
					mc.shutdown();
					return u;
				}
			}
		}
		if (user.getName() == u.getName()
				&& user.getPassword() == u.getPassword()) {
			System.out.println(
					(User) mc.get(u.getClass().getName() + u.getName()));
			mc.shutdown();
			return u;
		}
		return null;
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
