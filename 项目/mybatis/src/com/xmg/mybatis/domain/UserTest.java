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
			// �������
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
			// ͨ��factory�õ�sqlsession
			SqlSession session = sf.openSession();
			// �ҵ�SQL���������
			session.insert("com.xmg.mybatis.domain.UserMapper.add", user);
			// �ύ����
			session.commit();
			// �ر���Դ
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
	//ʹ��mapper�ķ���
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
	//ʹ��mapper�ķ���
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
	//ʹ��mapper�ķ���
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
	//ʹ��mapper�ķ���
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
	//ʹ��mapper�ķ���
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
	//ʹ��mapper�ķ���
	public void testChangePage(){
		UserSerive serive = new UserSerive();
		UserQueryObject qo = new UserQueryObject();
		qo.setCurrentPage(1);
		qo.setPageSize(10);
		serive.query(qo);
	}
	
	@Test
	//ʹ��mapper�ķ���
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
	//ʹ��mapper�ķ���
	public void testChangeLogin2(){
		SqlSession session = MybatisUtil.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user  = userMapper.login2("456", "email");
		System.out.println(user);
	}
}
