package com.hcm.dao;

import com.hcm.domain.User;

public interface UserDao {
	
	void save(User user) throws Exception;
	
	User get(Long id) throws Exception;

}
