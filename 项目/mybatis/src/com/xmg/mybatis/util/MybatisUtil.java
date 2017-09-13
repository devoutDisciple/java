package com.xmg.mybatis.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	private static MybatisUtil instance = new MybatisUtil();

	private SqlSessionFactory factory;

	private MybatisUtil() {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources
					.getResourceAsStream("mybatis-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSession() {
		return instance.factory.openSession();
	}
}
