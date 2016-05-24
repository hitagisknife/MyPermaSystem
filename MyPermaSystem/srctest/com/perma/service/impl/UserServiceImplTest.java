package com.perma.service.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.perma.model.User;

public class UserServiceImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(1);
		user.setName("÷‹ œ");
		user.setPassword("1");
		user.setRole("ÀÊ±„");
		int result = new UserServiceImpl().update(user);
		System.out.println(result);
	}

}
