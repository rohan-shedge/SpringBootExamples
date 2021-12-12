package com.rohan.jpa;

import java.util.List;

import org.springframework.context.ApplicationContext;

public class CustomQueryMethods {
	
	static UserRepository userRepository;
	
	public static void runCustomQueries(ApplicationContext context) {
		userRepository = context.getBean(UserRepository.class);
		java.util.List<User> user = (List<User>) userRepository.findByName("Nikhil");
		user.forEach(u -> System.out.println(u));
	}
}
