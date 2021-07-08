package com.sample.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.dao.UserDao;
import com.sample.vo.User;

public class SpringApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context-jdbc.xml");
		UserDao userDao = context.getBean(UserDao.class);
		
		User user = new User();
		user.setId("hong1234");
		user.setName("홍길동");
		user.setPassword("zxcv1234");
		user.setEmail("hong1234@gmail.com");
		user.setPhone("010-1111-2222");
		
		userDao.insertUser(user);
	}
}
