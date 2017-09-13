package com.xmg.mybatis.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xmg.mybatis.query.UserQueryObject;
import com.xmg.mybatis.query.UserSerive;
import com.xmg.mybatis.util.MybatisUtil;

public class UserTest {

	@Test
	public void testSave() {
		User user = new User();
		user.setName("456");
		user.setPassword("password");
		user.setEmail("email");
		user.setDate(new Date());
		try {
			// Properties properties = new Properties();
			// properties.load(Resources.getResourceAsStream("db.properties"));
			// 启动框架
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
			// 通过factory得到sqlsession
			SqlSession session = sf.openSession();
			// 找到SQL，保存对象
			session.insert("com.xmg.mybatis.domain.UserMapper.add", user);
			// 提交事务
			session.commit();
			// 关闭资源
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(2L);
		user.setName("zhangzhen");
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			session.update("com.xmg.mybatis.domain.UserMapper.update", user);
			session.commit();
		} catch (Exception e) {
			if (session != null) {
				session.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
	
	@Test
	//使用mapper的方法
	public void testChangeSave(){
		User user = new User();
		user.setName("zz123");
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			UserMapper userMapper = session.getMapper(UserMapper.class);
			userMapper.add(user);
			session.commit();
		} catch (Exception e) {
			if (session != null) {
				session.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@Test
	//使用mapper的方法
	public void testChangeUpdate(){
		User user = new User();
		user.setId(2L);
		user.setName("zzz11");
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			UserMapper userMapper = session.getMapper(UserMapper.class);
			userMapper.update(user);
			session.commit();
		} catch (Exception e) {
			if (session != null) {
				session.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@Test
	//使用mapper的方法
	public void testChangeDelete(){
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			UserMapper userMapper = session.getMapper(UserMapper.class);
			userMapper.delete(2L);
			session.commit();
		} catch (Exception e) {
			if (session != null) {
				session.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@Test
	//使用mapper的方法
	public void testChangeGet(){
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			UserMapper userMapper = session.getMapper(UserMapper.class);
			User user = userMapper.get(2L);
			session.commit();
			System.out.println(user);
		} catch (Exception e) {
			if (session != null) {
				session.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@Test
	//使用mapper的方法
	public void testChangeList(){
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			UserMapper userMapper = session.getMapper(UserMapper.class);
			List<User> list = userMapper.list();
			session.commit();
			System.out.println(list);
		} catch (Exception e) {
			if (session != null) {
				session.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@Test
	//使用mapper的方法
	public void testChangePage(){
		UserSerive serive = new UserSerive();
		UserQueryObject qo = new UserQueryObject();
		qo.setCurrentPage(1);
		qo.setPageSize(10);
		serive.query(qo);
	}
	
	@Test
	//使用mapper的方法
	public void testChangeLogin1(){
		Map<String, String> root = new HashMap<>();
		root.put("name", "login");
		root.put("email", "login");
		SqlSession session = MybatisUtil.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user  = userMapper.login1(root);
		System.out.println(user);
	}
	
	@Test
	//使用mapper的方法
	public void testChangeLogin2(){
		SqlSession session = MybatisUtil.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user  = userMapper.login2("456", "email");
		System.out.println(user);
	}
}
