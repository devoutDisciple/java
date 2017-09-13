package com.xmg.mybatis.domain;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xmg.mybatis.query.UserQueryObject;

public interface UserMapper {
	
	void add(User u);

	void update(User u);
	
	User get(Long id);
	
	void delete(Long id);
	
	List<User> list();
	
	int queryForCount(UserQueryObject qo);
	
	List<User> query(UserQueryObject qo);
	
	User login1(Map<String, String> root);
	
	User login2(@Param("name")String name, @Param("email")String email);
}
