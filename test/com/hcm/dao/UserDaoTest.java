package com.hcm.dao;

import org.junit.Test;

import com.hcm.dao.impl.UserDaoImpl;
import com.hcm.domain.User;

public class UserDaoTest {
	
	private UserDao userDao = new UserDaoImpl();
	
	@Test
	public void testSave() throws Exception {
		User user = new User("admin", "123456");
		userDao.save(user);
	}
	
	@Test
	public void testGet() throws Exception {
		User user = userDao.get((long)1);
		System.out.println("==> userId: " + user.getId());
		System.out.println("==> userName: " + user.getUsername());
		System.out.println("==> userPassword: " + user.getPassword());
	}

}
