package com.memcached.seri;

import java.io.Serializable;

import com.perma.model.User;

public class UserSeri extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6740516355946149679L;

	private int id;
	private String name;
	private String password;
	private String role;

	public UserSeri() {
	};

	public UserSeri(User u) {
		this.id = u.getId();
		this.name = u.getName();
		this.password = u.getPassword();
		this.role = u.getRole();
	}
}
