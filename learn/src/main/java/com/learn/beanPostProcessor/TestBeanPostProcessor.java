package com.learn.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * 实现了BeanPostProcessor之后需要交予Spring容器管理
 * 实现PriorityOrdered是规划BeanPostProcessor的先后顺序
 */
@Component
public class TestBeanPostProcessor implements BeanPostProcessor , PriorityOrdered {

	//Bean创建之后postConstruct之前执行
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("indexDao".equals(beanName)){
			System.out.println("BeanPostProcessor Before");
		}
		return bean;
	}

	//Bean创建之后postConstruct之后执行
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("indexDao".equals(beanName)){
			System.out.println("BeanPostProcessor after");
		}
		return bean;
	}

	/**
	 * 这里PriorityOrdered的实现类返回一个int数据类型
	 * 数据越大约往后排
	 * @return
	 */
	@Override
	public int getOrder() {
		return 101;
	}
}
