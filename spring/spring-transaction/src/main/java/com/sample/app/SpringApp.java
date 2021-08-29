package com.sample.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.service.UserService;
import com.sample.vo.User;

public class SpringApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/context-tx-aop.xml");
		
		UserService userService = context.getBean(UserService.class);
		User user = userService.getUserDetail("ong1000");
		System.out.println(user);
		
		User user2 = User.builder()
					.userId("tong1512").password("zxcv1234")
					.name("통길동").email("tong1512@gmail.com")
					.phone("010-1512-1512").build();
		System.out.println();
		System.out.println("####################### 신규사용자 정보 등록");
		userService.insertUser(user2);
	}
}
