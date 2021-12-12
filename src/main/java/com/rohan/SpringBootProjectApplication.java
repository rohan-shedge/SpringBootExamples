package com.rohan;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rohan.jpa.CrudOperations;
import com.rohan.jpa.CustomQueryMethods;
import com.rohan.jpa.JpqlNativeQueries;
import com.rohan.jpa.User;
import com.rohan.jpa.UserRepository;

@SpringBootApplication
public class SpringBootProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootProjectApplication.class, args);
		CrudOperations.performCrudOperation(context);
		System.out.println("_______________");
		CustomQueryMethods.runCustomQueries(context);
		System.out.println("______________");
		JpqlNativeQueries.runJpqlQueries(context);
		System.out.println("______________");
	}
}