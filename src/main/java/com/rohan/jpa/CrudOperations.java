package com.rohan.jpa;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;

public class CrudOperations {
	
	static UserRepository userRepository;
	
	private static User save(User user) {
		return userRepository.save(user);
	}
	
	private static Iterable<User> saveAll(List<User> list) {
		return userRepository.saveAll(list);
	}
	
	private static Optional<User> findById(int i) {
		return userRepository.findById(i);
	}

	private static void deleteById(int i) {
		userRepository.deleteById(i);
	}
	
	private static long count() {
		return userRepository.count();
		
	}
	
	public static void performCrudOperation(ApplicationContext context) {
		userRepository = context.getBean(UserRepository.class);
		
		User user1 = new User("Rohan", "Pune");
		User user2 = new User("Vivek", "mumbai");
		User user3 = new User("Nikhil", "Hyderabad");
		
		List<User> list = Arrays.asList(user1, user2, user3);
		save(user1);
		save(user2);
		save(user3);
		saveAll(list);
		
		Optional<User> user = findById(1);
		if (user.isPresent()) {
			System.out.println(user);
		}
		
		user.get().setName("rohan123");
		save(user.get());
		try {
		deleteById(2);
		}catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(count());

	}
}
