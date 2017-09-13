package com._520it.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final HibernateUtil instance = new HibernateUtil();

	//	sessionFactory���̰߳�ȫ�ģ����Կ��Զ���������
	private SessionFactory sessionFactory;

	private HibernateUtil() {
		// Configuration��hibernate�����ö���,Ȼ�����configureִ������
		Configuration cfg = new Configuration().configure();
		// ����sessionfactory����
		sessionFactory = cfg.buildSessionFactory();
	}

	public static HibernateUtil getInstance() {
		return instance;
	}

	public Session openSession() {
		return sessionFactory.openSession();
	}
}
