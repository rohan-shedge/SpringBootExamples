package com.rohan.jpa;

import java.util.List;

import org.springframework.context.ApplicationContext;

public class JpqlNativeQueries {
	static UserRepository userRepository;
	
	private static List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	private static List<User> getAllUsers(String name, String city) {
		return userRepository.getAllUsers(name, city);
	}
	
	private static List<User> getNativeUsers() {
		return userRepository.getAllUsers();
	}
	
	public static void runJpqlQueries(ApplicationContext context) {
		userRepository = context.getBean(UserRepository.class);
		List<User> users = getAllUsers();
		users.forEach(s -> System.out.println(s));
		
		System.out.println("_______________");
		System.out.println(getAllUsers("rohan123", "Pune"));

		System.out.println("________Native_______");
		users = getNativeUsers();
		users.forEach(s -> System.out.println(s));


	}
}
