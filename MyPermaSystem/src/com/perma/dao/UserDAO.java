package com.perma.dao;

import java.util.List;

import com.perma.model.User;

public interface UserDAO {

	public int add(User user);

	public int delete(int id);

	public int update(User user);

	public User login(User user);

	public List<User> getAll();
}
