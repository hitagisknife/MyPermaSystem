package com.perma.dao;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.perma.model.User;

public class UserDAOTest {

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
	public void testAdd() {
		User user = new User();
		user.setName("Æëï£");
		user.setPassword("000");
		user.setRole("Ã»ÓÐ");
	}

	@Test
	public void testDelete() {

	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

}
