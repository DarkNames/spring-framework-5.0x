package com.learn.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class TestBeanPostProcessor1 implements BeanPostProcessor, PriorityOrdered {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("indexDao".equals(beanName)){
			System.out.println("BeanPostProcessor Before1");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("indexDao".equals(beanName)){
			System.out.println("BeanPostProcessor after1");
		}
		return bean;
	}


	@Override
	public int getOrder() {
		return 100;
	}
}
