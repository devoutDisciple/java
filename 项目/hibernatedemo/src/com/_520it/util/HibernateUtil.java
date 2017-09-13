package com._520it.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final HibernateUtil instance = new HibernateUtil();

	//	sessionFactory是线程安全的，所以可以定义在外面
	private SessionFactory sessionFactory;

	private HibernateUtil() {
		// Configuration是hibernate的配置对象,然后调用configure执行配置
		Configuration cfg = new Configuration().configure();
		// 创建sessionfactory对象
		sessionFactory = cfg.buildSessionFactory();
	}

	public static HibernateUtil getInstance() {
		return instance;
	}

	public Session openSession() {
		return sessionFactory.openSession();
	}
}
