package com.learn.dao;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class IndexDao implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public IndexDao() {
		System.out.println("construct-------------->");
	}

	@PostConstruct
	public void init(){
		System.out.println("init ---------------->");
	}

	public void query(){
		System.out.printf("--------------->dao query");
	}

	/**
	 * 这里的applicationContext是ApplicationContextAwareProcessor 当中判断对象实现了
	 * ApplicationContextAware之后自动注入到这里的
	 * 这可以用来解决Scope一对多的问题，
	 * 可以通过实现ApplicationContextAware来获取applicationContext后获取spring新产生的依赖对象
	 * @param applicationContext the ApplicationContext object to be used by this object
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println(applicationContext);
	}
}
