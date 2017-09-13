package com.xmg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmg.domain.User;
import com.xmg.mapper.UserMapper;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	public void add(User u) {
		userMapper.add(u);
//		int i = 1/0;
//		u.setName("fuck");
//		userMapper.add(u);
	}

	public void update(User u) {
		userMapper.update(u);
	}

	public User get(Long id) {
		return userMapper.get(id);
	}

	public void delete(Long id) {
		userMapper.delete(id);
	}

	public List<User> list() {
		return userMapper.list();
	}

}
