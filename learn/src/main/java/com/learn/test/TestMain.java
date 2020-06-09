package com.learn.test;

import com.learn.beanFactoryProcessor.MyBeanFactoryProcessor;
import com.learn.config.AppConfig;
import com.learn.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
	public static void main(String[] args) {

//		AnnotationConfigApplicationContext annotationConfigApplicationContext =
//				new AnnotationConfigApplicationContext(AppConfig.class);

		//把Spring所有前提环节准备好，例如创建map容器DefaultListableBeanFactory
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext();
//		annotationConfigApplicationContext.register(IndexDao.class);
		annotationConfigApplicationContext.register(AppConfig.class);

		/** 这里添加的自定义BeanFactoryPostProcessor 必须放置在refresh之前 不然容器不会自动刷新*/
		annotationConfigApplicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryProcessor());
//
//		//初始化Spring环境
		annotationConfigApplicationContext.refresh();


		IndexDao dao = annotationConfigApplicationContext.getBean(IndexDao.class);
//		dao.query();
		IndexDao dao1 = annotationConfigApplicationContext.getBean(IndexDao.class);

		System.out.println(dao.hashCode() + "<==============>"+ dao1.hashCode());
		//System.out.printf("xxxx");
	}
}
