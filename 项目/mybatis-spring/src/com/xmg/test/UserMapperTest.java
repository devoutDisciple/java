package com.xmg.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xmg.domain.User;
import com.xmg.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserMapperTest {

	@Autowired
	private IUserService userService;
	
	@Test
	public void test() {
		User u = new User();
		u.setName("zhangzhen941025");
		userService.add(u);
	}

}
