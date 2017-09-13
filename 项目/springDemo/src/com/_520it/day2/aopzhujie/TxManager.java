package com._520it.day2.aopzhujie;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * @Aspect��ǩ�൱��<aop:aspect ref="" />
 * */
@Aspect
@Component
public class TxManager {

	/*
	 * ����һ��pointcut <aop:pointcut
	 * expression="execution(* com._520it.day2.aop.*.*Service(..))" id="pc" />
	 * ��������ķ���������һ���շ�������������Ӧid
	 */
	@Pointcut("execution(* com._520it.day2.aopzhujie.AopDemo.*(..))")
	public void pc() {
	}

	/*
	 * @Before��ǩ�൱��<aop:before method="before" 1:����ֱ��дpoint-cut���ʽ
	 */
	@Before("pc()")
	public void save() {
		System.out.println("Before");
	}

	/*
	 * �ڷ�������ִ�к�
	 */
	@AfterReturning("pc()")
	public void get() {
		System.out.println("AfterReturning");
	}

	/*
	 * �ڷ���ִ��֮�� ��finally֮��
	 */
	@After("pc()")
	public void after() {
		System.out.println("after");
	}
	
	@AfterThrowing(pointcut="pc()",throwing="ex")
	public void finallyFun(Throwable ex) {
		System.out.println("finallyFun" + ex.getMessage());
	}
}
