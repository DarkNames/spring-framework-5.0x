package com.learn.beanFactoryProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 当BeanFactoryPostProcessor的扩展点不需要交予Spring管理的时候
 * 可以通过annotationConfigApplicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryProcessor)
 * 来完成，两种方式都是以实现对Spring的扩展，通常还是会使用第一种
 */
//@Component
public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AnnotatedBeanDefinition annotatedBeanDefinition = (AnnotatedBeanDefinition) beanFactory.getBeanDefinition("indexDao");
		annotatedBeanDefinition.setScope("prototype");

	}
}
