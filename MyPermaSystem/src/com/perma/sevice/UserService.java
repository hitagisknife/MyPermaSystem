package com.perma.sevice;

import java.util.List;

import com.perma.model.User;

public interface UserService {

	public User login(User user);

	public int register(User user, String password2);

	public int update(User user);

	public int delete(int id);

	public List<User> getAll();
}
