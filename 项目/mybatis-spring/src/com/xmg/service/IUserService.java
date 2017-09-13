package com.xmg.service;

import java.util.List;

import com.xmg.domain.User;

public interface IUserService {
	void add(User u);

	void update(User u);
	
	User get(Long id);
	
	void delete(Long id);
	
	List<User> list();
}
