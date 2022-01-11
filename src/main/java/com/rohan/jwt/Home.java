package com.rohan.jwt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	
	@GetMapping("/welcome")
	public String welcome() {
		String text =  "This is a private message";
		text += "This page is nt allowed for authenticated users";
		return text;
	}
}
