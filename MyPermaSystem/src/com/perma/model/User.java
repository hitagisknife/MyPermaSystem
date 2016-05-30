package com.perma.model;

import java.io.Serializable;

import lombok.Data;

public @Data class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8197560830618506320L;
	private int id;
	private String name;
	private String password;
	private String role;
}