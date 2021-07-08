package com.sample.di.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("context-di-demo2.xml");
		
		OrderService orderService = container.getBean("orderService", OrderService.class);
		orderService.order();
		System.out.println();
		orderService.cancel();
		
		CustomerService customerService = container.getBean(CustomerService.class);
		customerService.getMyInfo();
		System.out.println();
		customerService.getMyOrderList();;
	}
}
