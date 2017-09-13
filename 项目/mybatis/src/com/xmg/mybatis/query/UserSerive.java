package com.xmg.mybatis.query;

import java.util.List;

import com.xmg.mybatis.domain.User;
import com.xmg.mybatis.domain.UserMapper;
import com.xmg.mybatis.util.MybatisUtil;

public class UserSerive {
	private static UserMapper userMapper;
	
	public UserSerive(){
		userMapper = MybatisUtil.getSession().getMapper(UserMapper.class);
	}
	
	public void query(UserQueryObject qo){
		int totalCount = userMapper.queryForCount(qo);
		if(totalCount > 0){
			List<User> list = userMapper.query(qo);
			System.out.println(list);
		}
	}
	
}
