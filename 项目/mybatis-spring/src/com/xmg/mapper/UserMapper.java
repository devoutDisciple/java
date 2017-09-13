package com.xmg.mapper;

import java.util.List;

import com.xmg.domain.User;

public interface UserMapper {
	
	void add(User u);

	void update(User u);
	
	User get(Long id);
	
	void delete(Long id);
	
	List<User> list();
}
