package com.perma.model;

import lombok.Data;

public @Data class User {

	private int id;
	private String name;
	private String password;
	private String role;
}