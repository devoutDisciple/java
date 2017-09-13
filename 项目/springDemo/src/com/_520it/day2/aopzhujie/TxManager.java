package com._520it.day2.aopzhujie;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * @Aspect标签相当于<aop:aspect ref="" />
 * */
@Aspect
@Component
public class TxManager {

	/*
	 * 声明一个pointcut <aop:pointcut
	 * expression="execution(* com._520it.day2.aop.*.*Service(..))" id="pc" />
	 * 就像下面的方法，定义一个空方法，方法名对应id
	 */
	@Pointcut("execution(* com._520it.day2.aopzhujie.AopDemo.*(..))")
	public void pc() {
	}

	/*
	 * @Before标签相当于<aop:before method="before" 1:可以直接写point-cut表达式
	 */
	@Before("pc()")
	public void save() {
		System.out.println("Before");
	}

	/*
	 * 在方法正常执行后
	 */
	@AfterReturning("pc()")
	public void get() {
		System.out.println("AfterReturning");
	}

	/*
	 * 在方法执行之后 在finally之中
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
